package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	private Socket socket = null;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			while (true) {
				String msg = br.readLine();
				System.out.println(msg);
			}
		} catch (SocketException e) {
			ChatClientThread.interrupted();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
