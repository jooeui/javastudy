package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<PrintWriter> clientList = new ArrayList<PrintWriter>();
	
	public ChatServerThread(Socket socket, List<PrintWriter> clientList) {
		this.socket = socket;
		this.clientList = clientList;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
			
			while(true) {
				String line = br.readLine();
				if(line == null) {
					removeClient(pw);
					break;
				}
				
				String[] tokens = line.split(":");
				if("JOIN".equals(tokens[0])) {
					join(tokens[1], pw);
				} else if("Message".equals(tokens[0])){
					broadcast(this.nickname + ": " + tokens[1]);
				} else if("quit".equals(tokens[0])) {
					removeClient(pw);
				}
			}
		} catch (IOException e) {
			String data = nickname + "님이 퇴장했습니다.";
			broadcast(data);
		}
	}

	private void join(String nickname, PrintWriter client) {
		this.nickname = nickname;
		
		String data = nickname + "님이 입장하였습니다.";
		
		synchronized (clientList) {
			clientList.add(client);
		}
		
		broadcast(data);
	}

	private void removeClient(PrintWriter client) {
		synchronized (clientList) {
			clientList.remove(client);
		}
	}
	
	private void broadcast(String data) {
		ChatServer.log(data);

		synchronized(clientList) {
			for(PrintWriter writer : clientList) {
				writer.println(data);
				writer.flush();
			}
		}
		
	}
	
	

}
