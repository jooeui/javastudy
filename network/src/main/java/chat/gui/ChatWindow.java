package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ChatWindow {
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private Socket socket;

	public ChatWindow(String nickname, Socket socket) {
		frame = new Frame(nickname);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);

		this.socket = socket;

//		List<PrintWriter> clientList = new ArrayList<PrintWriter>();
//		textArea.append(nickname + "님, 채팅방에 접속하셨습니다!\n");
//		for(PrintWriter participant : clientList) {
//			textArea.append(participant);			
//		}
//		
		new ChatClientThread(socket).start();
	}

	public void show() {
		/*
		 * 1. UI 초기화
		 */

		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() { // registerObserver
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		/*
		 * buttonSend.removeActionListener(e -> System.out.println()); //
		 * unregisterObserver buttonSend.addActionListener((e) -> {
		 * System.out.println("click!"); }); buttonSend.addActionListener((e) ->
		 * System.out.println("click!"));
		 */

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() { // Anonymous Class 구현 가능. but, lamda는 불가능
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}

		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
				// System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();

		/*
		 * 2. IOStream 가져오기 - sendMessage()
		 */

		/*
		 * 3. Chat Client Thread 생성
		 */
	}

	private void sendMessage() {
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			String message = textField.getText();
			if("quit".equals(message)) {
				finish();
			}
			String request = "Message:" + message;
			pw.println(request);

			textField.setText("");
			textField.requestFocus();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Receive Thread 에서 서버로 부터 받은 메세지가 있다고 가정 (가짜 데이터)
		// updateTextArea("마이콜: " + message); // thread에 있어야함 !!
	}

	protected void finish() {
		// System.out.println("소켓 닫기 or 방 나가기 프로토콜 구현!");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			String request = "quit";
			pw.println(request);
			ChatClientApp.log("채팅방을 나갑니다.");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private class ChatClientThread extends Thread {
		Socket socket = null;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

				while (true) {
					String msg = br.readLine();
					updateTextArea(msg);
				}
			} catch (SocketException e) {
				ChatClientApp.log("채팅방이 종료되었습니다. 이 채팅방은 접속할 수 없습니다.");
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null && socket.isClosed() == false) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
