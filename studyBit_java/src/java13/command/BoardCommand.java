package java13.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java13.Board;
import java13.BoardDao;
import java13.annotation.Command;
import java13.annotation.Component;

@Component
public class BoardCommand {
	Scanner scanner;
	BoardDao boardDao;
	Date date;
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Command("add")
	public void add(HashMap<String, Object> params) throws Exception {
		ArrayList<String> contents = new ArrayList<String>();
		String inputTitle;
		String inputContent;
		String inputPwd;
		String selector;
		
		System.out.print("제목 : ");
		inputTitle = scanner.nextLine();
		
		System.out.print("내용 : ");
		while(true){
			inputContent = scanner.nextLine();
			
			if (!inputContent.equals("")) {	
				contents.add(inputContent);
			}else{
				break;
			}
		}
		
		System.out.print("암호 : ");
		inputPwd = scanner.nextLine();
		
		System.out.print("저장하시겠습니까 ( y / n )");
		selector = scanner.nextLine().toLowerCase();
		
		switch (selector) {
		case "y" : 
			boardDao.getList().add(new Board(inputTitle,contents,inputPwd));
			System.out.println("저장였습니다.");
			break;
		case "n" :
			System.out.println("취소하였습니다.");
			break;
		default : 
			System.out.println("잘못된 명령입니다."); 
			break;
		}
		
	}
	@Command("list")
	public void list(HashMap<String, Object> params) throws Exception {
		int index = 0;

		for(Object item : boardDao.getList()){
			System.out.printf("번호:%2d    날짜:%2s    제목:%2s \n", 
					index, 
					boardDao.getList().get(index).getCalendar(),
					boardDao.getList().get(index).getTitle());
			index++;
		}
	}
	
	@Command("update")
	public void update(HashMap<String, Object> params){
		ArrayList<String> options= (ArrayList<String>) params.get("options");
		int index = Integer.parseInt(options.get(0));
		
		System.out.println("제목(" + boardDao.getList().get(index).getTitle()+")");
		String newTitle = scanner.nextLine();
		
		for(int i = 0; i < 3; i++){
			System.out.println("변경하려면 암호를 입력하세요 : ");
			String checkPw = scanner.nextLine();
			if (i == 2) {
				System.out.println("변경 자동 취소하였습니다.");
				break;

			} else {

				if (!boardDao.getList().get(index).getPwd().equals(checkPw)) {
					System.out.println("암호가 틀렸습니다.");
				} else {
					boardDao.getList().get(index).setTitle(newTitle);
					System.out.println("변경되었습니다.");
					break;
				}
			}
		}
	}
	
}
