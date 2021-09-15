package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;
	
	public static void main(String[] args) {
		// 1. 소켓 생성
		Socket socket = null;
		
		try {
			// 2. 서버 연결
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
		} catch (SocketException e) {
			System.out.println("[Client] Suddenly closed by server");
		} catch (IOException e) {
			System.out.println("[Client] Error: " + e);
		} finally {
			try {
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
