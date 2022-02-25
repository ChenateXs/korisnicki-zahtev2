package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import admin.User;

public class Login{
	
	List<User> allUsers;
	User currentUser;
	
	public Login(List<User> allUsers) {
		this.allUsers = allUsers;
	}

	public User LogingIn() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String username;
		String password;
		User LogedInCorrectly = null;
		for(int i = 0;i<4;i++){
			try {
				System.out.println("Log In");
				System.out.println("Username:");
				username = reader.readLine();
				
				System.out.println("Password:");
				password = reader.readLine();

				LogedInCorrectly = checkLogIn(username,password);
				if(LogedInCorrectly != null) {break;}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return LogedInCorrectly;
	}
	
	private User checkLogIn(String username, String password) {
		for(User u: allUsers) {
			if(u.getUsername().equals(username)&&u.getPassword().equals(password)) return u;
		}
		return null;
	}
	
}
