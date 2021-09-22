package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 8888;
	
	public static void main(String[] args) {
		String nickname = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		
		try {
			while(true) {
				System.out.print("닉네임을 입력하세요: ");
				nickname = scanner.nextLine();
				
				if(nickname.isEmpty() == false) {
					break;
				}
				
				System.out.println("올바른 닉네임을 입력하세요.");
				System.out.println();
			}
			
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			String request = "JOIN:" + nickname + "\r\n";
			pw.println(request);
			
			System.out.println("채팅방에 접속하셨습니다.");
			new ChatClientThread(socket).start();
			
			while(true) {
				String message = scanner.nextLine();
				request = "Message:" + message + "\r\n";
				
				if("quit".equals(message)) {
					request = "quit\r\n";
					pw.println(request);
					break;
				}
				
				pw.println(request);
			}
		} catch (IOException e) {
			log("Error: " + e);
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void log(String log) {
		System.out.println(log);
	}

}
