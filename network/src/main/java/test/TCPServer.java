package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		/* TCP 소켓 프로그래밍 절차 - 서버 */
		ServerSocket serverSocket = null;

		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(binding)
			// 	  Socket에 InetSocketAddress(IPAdderess + port)
			//	  IPAdress: 0.0.0.0 -> 특정 호스트 IP binding 하지 않음
			//				"118.38.27.103" -> 특정 호스트 IP binding은 바뀌기 때문에 다른 곳에서 연결 불가. 하지 맙시다!
			//				InetAddress.getLocalHost() -> 자신의 IP를 불러와 해당 IP만 연결 허용
			// serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 5000));
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000));
			
			// 3. accept
			//	  클라이언트로 부터 연결 요청을 기다림
			Socket socket = serverSocket.accept();	// blocking

			// $ telnet 127.0.0.1(or localhost|자신의 IP) 5000으로 연결해봅시당
			// System.out.println("연결!");		
			
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			System.out.println("[Server] connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");
			
			try {
				// 4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);	// blocking
					if(readByteCount == -1) {
						// 클라이언트가 정상적으로 종료(close() 호출)
						System.out.println("[Server] closed by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[Server] received: " + data);
					
					// 6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}
			} catch(SocketException e) {
				System.out.println("[Server] Suddenly closed by client");
			} catch(IOException e) {
				System.out.println("[Server] Error: " + e);
			} finally {
				try {
					if(socket != null && socket.isClosed() == false) {
						socket.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
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
