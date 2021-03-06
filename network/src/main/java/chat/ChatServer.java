package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int PORT = 8888;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<PrintWriter> clientList = new ArrayList<PrintWriter>();

		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("채팅 서버를 열었습니다.");

			// 3. 요청 대기
			while (true) {
				Socket socket = serverSocket.accept();	// blocking
				new ChatServerThread(socket, clientList).start();
			}
		} catch (IOException e) {
			log("Error: " + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[Server] " + log);
	}

}
