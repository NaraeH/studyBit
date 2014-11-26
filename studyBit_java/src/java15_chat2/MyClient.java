package java15_chat2;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient extends Frame{
	TextField tfInput = new TextField(20);
	Button btnSend = new Button("send");
	
	Socket socket = null;
	Scanner in = null;
	PrintStream out = null;
	
	public MyClient(){
		Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		panel.add(tfInput);
		panel.add(btnSend);
		this.add(panel);
	}
	
	public void go(){
		try{
			System.out.println("서버와 연결을 기다리고 있습니다....");
			socket = new Socket("192.168.0.115", 5555);
			System.out.println("서버와 연결 되었습니다.");
			
				in = new Scanner(socket.getInputStream());
				System.out.println("server로부터 온 advice: " + in.nextLine());
				
				out = new PrintStream(socket.getOutputStream());
				
				btnSend.addActionListener(new BtnSend());
			
			in.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	class BtnSend implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		}
		
	}
	
	public static void main(String[] args) {
		MyClient client = new MyClient();
		client.go();
		client.setSize(400, 200);
		client.setVisible(true);
	}
}
