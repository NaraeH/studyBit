package java15_chat1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
	Socket socket = null;
	Scanner in = null;
	
	public void go(){
		try{
			System.out.println("서버와 연결을 기다리고 있습니다....");
			socket = new Socket("192.168.0.115", 5555);
			System.out.println("서버와 연결 되었습니다.");
			
			in = new Scanner(socket.getInputStream());
			System.out.println("server로부터 온 advice: " + in.nextLine() );
			
			in.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyClient client = new MyClient();
		client.go();
	}
}
