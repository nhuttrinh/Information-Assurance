import java.util.ArrayList;
import java.util.Scanner;

public class secure_house {
	protected static String owner, currInsert, currTurn, currKey;
	 protected static ArrayList<String> key = new ArrayList<String>();
	 protected static ArrayList<String> peopleInside = new ArrayList<String>();
	 protected static String fireKey = "FIREFIGHTER_SECRET_KEY";
	 protected static boolean insertFlag = false, turnFlag = false;

	public static void insertCommand(String user, String keyInsert) {
		currInsert = user;
		currKey = keyInsert;
		
		if(key.contains(keyInsert)) {
			insertFlag = true;
		}
		else {
			insertFlag = false;
		}
		System.out.println("KEY "+ keyInsert + " INSERTED BY " + user);
		
	}
	
	public static void turnCommand(String user) {
		
		if(currInsert.equals(user) && insertFlag) {
			currTurn = user;
			turnFlag = true;
			System.out.println("SUCCESS " + user + " TURNS KEY " + currKey);
		}
		else {
			System.out.println("FAILURE " + user + " UNABLE TO TURN KEY " + currKey);
		}
		insertFlag = false;
	}
	
	public static void enterCommand(String user) {
		if(user.contentEquals(currInsert) && user.equals(currTurn) && turnFlag) {
			peopleInside.add(user);
			System.out.println("ACCESS ALLOWED");
		}
		else {
			System.out.println("ACCESS DENIED");
		}
		turnFlag = false;
	}
	
	public static void inside() {
		if(peopleInside.size() > 0) {
			for(int i = 0; i<peopleInside.size();i++) {
				if(i<peopleInside.size()-1) {
				System.out.print(peopleInside.get(i) + ", ");
				}
				else if(i <peopleInside.size()) {
					System.out.print(peopleInside.get(i) + "\n");
				}
			}
		}
		else {
			System.out.println("NOBODY HOME");
		}	
	}
	
	public static void changeLocks(String user, ArrayList<String> tempKey) {
		if(user.equals(owner) && peopleInside.contains(owner)) {
			key.clear();
			for(int i = 0; i < tempKey.size();i++) {
				key.add(tempKey.get(i));
			}
			key.add(fireKey);
			System.out.println("OK");
		}
		else {
			System.out.println("ACCESS DENIED");
		}
	}
	
	public static void leaveHouse(String user) {
		if(peopleInside.contains(user)) {
			peopleInside.remove(user);
			System.out.println("OK");
		}else {
			System.out.println(user + " NOT HERE");
		}
	}
	
	public static void executeCommand(String commandLine) {
		String[] command = commandLine.split(" ");
				
		switch(command[0]) {
		
		case "INSERT":
			if(command[1].equals("KEY")) {insertCommand(command[2],command[3]);}
			else{
				System.err.println("ERROR");
			};break;
		case "TURN":
			if(command[1].equals("KEY")) {turnCommand(command[2]);}
			else{
				System.err.println("ERROR");
			};break;
		case "ENTER":
			if(command[1].equals("HOUSE")) {enterCommand(command[2]);}
			else{
				System.err.println("ERROR");
			};break;
		case "WHO'S":
			if(command[1].equals("INSIDE?")) {inside();}
			else{
				System.err.println("ERROR");
			};break;
		case "CHANGE"
				+ "":
			if(command[1].equals("LOCKS")) {
				ArrayList<String> tempKey = new ArrayList<String>();
				for(int i = 3; i< command.length;i++) {
					tempKey.add(command[i]);
					
				}
				changeLocks(command[2],tempKey);
				}
				else{
					System.err.println("ERROR");
				};break;
		case "LEAVE":
			if(command[1].equals("HOUSE")) {leaveHouse(command[2]);};break;
		default: System.err.println("ERROR"); break;
		}
	}

	public static void main(String[] args) throws Exception {
	
		Scanner scanner  = new Scanner(System.in);
		
		owner = args[0];

		for(int i = 1; i < args.length;i++) {
			key.add(args[i]);
		}
		key.add(fireKey);
		
		while(scanner.hasNextLine()) {
			
			String commandLine = scanner.nextLine();
			executeCommand(commandLine);
		}
		
		scanner.close(); 
		 
	}
}

