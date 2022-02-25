package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import admin.User;

public class Login implements Runnable{
	
	List<User> allUsers;
	
	
	public Login(ArrayList<User> allUsers) {
		this.allUsers = allUsers;
	}

	@Override
	public void run() {
		boolean LogedIn = LogingIn();
		while(LogedIn) {
			
		}
		System.out.println(LogedIn);
	}

	private boolean LogingIn() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String username;
		String password;
		boolean LogedInCorrectly = false;
		for(int i = 0;i<4;i++){
			try {
				System.out.println("Log In");
				System.out.println("Username:");
				username = reader.readLine();
				
				System.out.println("Password:");
				password = reader.readLine();

				LogedInCorrectly = checkLogIn(username,password);
				
				if(LogedInCorrectly) break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return LogedInCorrectly;
	}
	
	private boolean checkLogIn(String username, String password) {
		for(User u: allUsers) {
			if(u.getSurname().equals(username)&&u.getPassword().equals(password)) return true;
		}
		return false;
	}
	
}
