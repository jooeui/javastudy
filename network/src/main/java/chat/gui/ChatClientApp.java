package chat.gui;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 7878;

	public static void main(String[] args) {
		String nickname = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		try {
			while (true) {
				System.out.println("닉네임을 입력하세요.");
				System.out.print(">> ");
				nickname = scanner.nextLine();

				if (nickname.isEmpty() == false) {
					break;
				}
				log("올바른 닉네임을 입력하세요.\n");
			}

			scanner.close();

			// 1. create socket
			socket = new Socket();

			// 2. connect to server
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			// 3. get IOStream
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 4. join
			String request = "JOIN:" + nickname;
			pw.println(request);

			log(nickname + "님, 채팅방에 접속하셨습니다!");
			new ChatWindow(nickname, socket).show();
		} catch (SocketException e) {
			log("채팅방이 종료되었습니다. 이 채팅방은 접속할 수 없습니다.");
		} catch (IOException e) {
			log("Error: " + e);
		}
	}

	public static void log(String log) {
		System.out.println(log);
	}
}
