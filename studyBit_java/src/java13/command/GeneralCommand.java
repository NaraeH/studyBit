package java13.command;

import java.util.HashMap;
import java.util.Scanner;
import java13.BoardDao;
import java13.annotation.Command;
import java13.annotation.Component;

@Component
public class GeneralCommand {
	BoardDao boardDao;
	Scanner scanner;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}


	@Command("exit")
	public void doExit(HashMap<String, Object> params){
		boardDao = new BoardDao();
		boardDao.save();
		scanner.close();
		
	}
}
