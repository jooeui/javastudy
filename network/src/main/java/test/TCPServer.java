package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		/* TCP 소켓 프로그래밍 절차 - 서버 */
		ServerSocket serverSocket = null;

		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(binding)
			// 	  Socket에 InetSocketAddress(IPAdderess + port)
			//	  IPAdress: 0.0.0.0 -> 모든 IP로 부터의 연결 허용
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000));
			
			// 3. accept
			//	  클라이언트로 부터 연결 요청을 기다림
			Socket socket = serverSocket.accept();	// blocking

			// $ telnet 127.0.0.1(or localhost|자신의 IP) 5000으로 연결해봅시당
			// System.out.println("연결!");		
			
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			
			System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");
			
			
		} catch (IOException e) {
			System.out.println("[Server] Error: " + e);
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
