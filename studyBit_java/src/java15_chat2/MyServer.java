package java15_chat2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	ServerSocket serverSocket = null;
	Socket socket = null;
	PrintStream out = null;
	String message = null;

	public void go() {
		try {
			serverSocket = new ServerSocket(5555);
			System.out.println("서버와의 연결을 기다리고 있습니다.");
			
			socket = serverSocket.accept();
			System.out.println("서버와 연결되었습니다");
			
			out = new PrintStream(socket.getOutputStream());
			message = getAdvice();
			out.println(message);
			
			out.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String getAdvice(){
		String[] advices = {"밥 조금만 먹어", "오늘 집에가는 건 어때?", "저녁은 햄버거?"};
		int num = 0;
		
		num = (int)(Math.random() * advices.length);
		
		return advices[num];
	}

	public static void main(String[] args) {
		MyServer server = new MyServer();
		server.go();
	}

}
