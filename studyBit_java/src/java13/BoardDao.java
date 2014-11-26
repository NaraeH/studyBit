package java13;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardDao {

	static ArrayList<Board> list = new ArrayList<Board>();
	String filename;
	Scanner scanner;
	
	public BoardDao(){
		this.filename = "board.dat";
	}
	
	public BoardDao(String filename){
		this.filename = filename;
	}

	public static void setList(ArrayList<Board> list) {
		BoardDao.list = list;
	}
	
	public static ArrayList<Board> getList() {
		return list;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void add(Board data){
		list.add(data);
	}
	
	public void change(int index, Board data){
		list.set(index, data);
	}
	
	public void load() throws FileNotFoundException {
		Scanner dataScanner = null;
		try {
			dataScanner = new Scanner(new FileReader(filename));
			
			while (true) {
				try {
					String token = dataScanner.nextLine();
					list.add(new Board(token));
				}catch (Exception e) {
					break;
				}
			}
			System.out.println("data 로딩이 성공하였습니다.");
		} catch (FileNotFoundException e) {
			list.clear();
			System.out.println("data 로딩이 실패하였습니다.");
		} finally {
			dataScanner.close();
		}
		
	}

	public void save() {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(filename));
			
			for (Board board : list) {
				out.write(board.getTitle() + "  " + 
							board.getContents() + "  " + 
							board.getPwd() + "  " + 
							board.getCalendar() + "\n");
			}
			System.out.println("데이터가 저장 되었습니다.");
			
		}catch (IOException ie) {
			System.out.println("데이터 저장 중 오류 발생");
		}finally{
			try {
				out.close();
			} catch (Exception e) {}
		}
	}
}