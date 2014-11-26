package java16_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Products {
	Connection con = null;
	Scanner in = null;
	String[] inputs = null;
	Statement stmt = null;

	public void conInit() {
		String url = null;
		String id = null;
		String pw = null;
		
		try {
			url = "jdbc:mysql://localhost:3306/studydb";
			id = "study";
			pw = "study";
			
			Class.forName("com.mysql.jdbc.Connection");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB에 연결 되었습니다.");
			
			stmt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void menu() throws Exception{
		menu: 
		while (true) {
			System.out.print("명령> ");

			in = new Scanner(System.in);
			inputs = in.nextLine().split(" ");
			
			switch (inputs[0]) {
			case "add":
				add();
				break;
			case "list":
				list();
				break;
			case "update":
				update(Integer.parseInt(inputs[1]));
				break;
			case "delete":
				delete(Integer.parseInt(inputs[1]));
				break;
			case "exit":
				destroy();
				break menu;
			default:
				System.out.println("지원하지 않는 명령어 입니다.");
			}
		}

	}

	public void add() {
		String pname = null;
		int qty = 0;
		int mkno = 0;
		String select = null;
		
		try{
		System.out.print("제품명: ");
		pname = in.nextLine();
		
		System.out.print("수량: ");
		qty = in.nextInt();
		
		System.out.print("제조사: ");
		mkno = in.nextInt();
		
		System.out.print("저장하시겠습니까? (y / n): ");
		select = in.next();
		
		switch(select.toLowerCase()){
		case "y":
			try{
				stmt.executeUpdate("INSERT INTO PRODUCTS(PNAME, QTY, MKNO) values (" 
						+ pname + ","
						+ qty + ","
						+ mkno + ");");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("저장 실패하였습니다.");
			}
			System.out.println("저장하였습니다.");
			break;
			
		case "n":
			System.out.println("저장 취소하였습니다.");
			break;
		}
		}catch(Exception e){
			System.out.println("잘못입력하셨습니다.");
		}
	}

	public void list() throws Exception {
		ResultSet rs = null; 
			rs = stmt.executeQuery("SELECT p.pno, p.pname, p.qty, m.mkname "
					+ "FROM products p, makers m "
					+ "where p.mkno = m.mkno;");
			System.out.printf("%2s %25s %7s %10s\n", "번호", "제품명", "수량", "제조사명");
			while(rs.next()){
				System.out.printf("%2d", rs.getInt("PNO"));
				System.out.printf("%20s", rs.getString("PNAME"));
				System.out.printf("%7d", rs.getInt("QTY"));
				System.out.printf("%10s \n", rs.getString("MKNAME"));
			}
			
			rs.close();
	}

	public void update(int index) throws Exception{
		System.out.println(index);
		
		ResultSet rs = null; 
		String tPname = null;
		int tQty = 0;
		int tMkno = 0;
		
		rs = stmt.executeQuery("SELECT pname, qty, mkno FROM products Where pno=" + index);
		
		while(rs.next()){

			System.out.print("제품명(" + rs.getString("PNAME") + ")? ");
			tPname = in.nextLine();

			System.out.print("수량(" + rs.getInt("QTY") + ")? ");
			tQty = in.nextInt();

			System.out.print("제조사(" + rs.getInt("MKNO") + ")? ");
			tMkno =in.nextInt();
		}

		stmt.executeUpdate("UPDATE products SET "
				+ "pname=" + "'" + tPname + "'"
				+ ", qty=" + tQty 
				+ ", mkno=" + tMkno
				+ " WHERE pno=" + index);
		
		System.out.println("변경하였습니다.");
		rs.close();
	}
	
	public void delete(int index) throws Exception{
		ResultSet rs = null;
		String selector= null;
		
		rs =stmt.executeQuery("SELECT pname FROM products WHERE pno=" + index);

		while (rs.next()) {
			System.out.println(rs.getString("PNAME") + "을 삭제 하시겠습니까? (y/n)");
		}
		selector = in.nextLine();

		switch (selector.toLowerCase()) {
		case "y":
			stmt.executeUpdate("DELETE FROM products WHERE pno=" + index);
			System.out.println("삭제하였습니다.");
			break;
		case "n":
			System.out.println("취소하였습니다.");
		}
		rs.close();

	}

	public void destroy() throws Exception{
		in.close();
		stmt.close();
		con.close();
		
		System.out.println("destory");
		System.out.println("프로그램이 종료되었습니다.");
	}
}
