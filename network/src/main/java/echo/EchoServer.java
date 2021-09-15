package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final int PORT = 6000;
	
	// java echo.EchoServer 6000 -> args 변경해보기
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));		// Socket에 InetSocketAddress(IPAddress + Port) binding
			log("starts... [port:" + PORT + "]");
			
			Socket socket = serverSocket.accept();	// blocking
			
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			log("connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				
				// flush true - 쓸 때마다 자동으로 flush(autoFlush), false로 하면 명시적으로 flush를 써줘야 함
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
				
				while(true) {
					String data = br.readLine();
					if(data == null) {
						log("closed by client");
						break;
					}
					
					log("received: " + data);
					pw.println(data);
				}
			} catch(IOException e) {
				log("error: " + e);
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
			log("error: " + e);
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
	
	public static void log(String log) {
		System.out.println("[EchoServer] " + log);
	}

}
