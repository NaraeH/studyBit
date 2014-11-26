package java13;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java13.annotation.Command;
import java13.annotation.Component;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

public class BoardApp {
	static class CommandInfo{
		Object instance;
		Method method;		
	}

	HashMap<String, CommandInfo> commandMap;
	CommandInfo commandInfo;
	Scanner scanner;
	BoardDao boardDao;

	private void init() {
		scanner = new Scanner(System.in);
		boardDao = new BoardDao();
		try {
			boardDao.load();

		} catch (Exception e) {
			System.out.println("데이터 로딩 중 오류");
		}

		try {
			Object command;
			Command commandAnno;
			commandMap = new HashMap<String, CommandInfo>();
			Method method;
			
			Reflections reflections = new Reflections("java13");
			Set<Class<?>> classList = reflections.getTypesAnnotatedWith(Component.class);
			 
			for(Class clazz:classList){
				command = clazz.newInstance();
				commandAnno = null;

				Set<Method> methods = ReflectionUtils.getMethods(clazz, ReflectionUtils.withAnnotation(Command.class));

				for (Method m : methods) {
					commandInfo = new CommandInfo();
					commandAnno = m.getAnnotation(Command.class);
					commandInfo.instance = command;
					commandInfo.method = m;

					commandMap.put(commandAnno.value(),commandInfo);
				}

				try {
					method = clazz.getMethod("setBoardDao", BoardDao.class);
					method.invoke(commandInfo.instance, boardDao);
				}catch(Exception e){}

				try{
					method = clazz.getMethod("setScanner", Scanner.class);
					method.invoke(commandInfo.instance, scanner);
				}catch(Exception e){}
			}

			/*Set<String> keyset = commandMap.keySet();
			for(String key : keyset){
				System.out.println(key +  "==>" + commandMap.get(key));
			}*/

		} catch (Exception e) {}

	}

	private void service()  {

		CommandInfo commandInfo = null;
		loop: while (true) {
			
			try {
				String[] token = promptCommand();
				commandInfo = commandMap.get(token[0]) ;
				
				if (commandInfo == null) {
					System.out.println("명령어 오류. 다시 시도해주세요");
					continue;
				}

				HashMap<String, Object> params = new HashMap<String, Object>();
				ArrayList<String> options = new ArrayList<String>();

				for (int i = 1; i < token.length; i++) {
					options.add(token[i]);
				}

				params.put("options", options);

				commandInfo.method.invoke(commandInfo.instance, params);

				if (token[0].equals("exit")) {
					break loop;
				}
			} catch (Exception e) {
				System.out.println("명령어 입력이 바르지 않습니다.");
			}
		}// while

	}


	private void destroy() {
		scanner.close();
	}

	private String[] promptCommand(){
		System.out.print("명령>> ");
		return scanner.nextLine().split(" ");
	}

	public static void main(String[] args) {
		BoardApp app = new BoardApp();

		app.init();
		app.service();
		app.destroy();

	}


}
