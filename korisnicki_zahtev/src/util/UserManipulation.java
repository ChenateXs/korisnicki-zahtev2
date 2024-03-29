package util;

import java.util.List;
import java.util.Scanner;

import admin.Role;
import admin.User;

public class UserManipulation {

	List<User> users;

	public void showUsers() {
		System.out.println(users);
	}

	public void showUser(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				System.out.println(user);
				break;
			}
		}
	}

	public void insert(User user) {
		boolean b = true;
		for (User listUser : users) {
			if (listUser.getName().equals(user.getName()))
				b = false;
		}
		char[] pass;
		pass = user.getPassword();
		if (!Character.isLetter(pass[0]))
			b = false;
		boolean contains = false;
		for (int i = 0; i < pass.length; i++) {
			if (Character.isDigit(pass[i]))
				b = true;
		}
		if(b&&contains) users.add(user);

	}

	public void change(User user) {
		System.out.println("Sta zelite da promenite? Unesite redni broj");
		System.out.println("1.username");
		System.out.println("2.password");

		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();

		if (i == 1) {
			System.out.println("Unesite novo ime");
			String string = scanner.nextLine();
			changeUsername(string, user);
		} else if (i == 2) {
			System.out.println("Unesite novi password");
			String string = scanner.nextLine();
			changePassword(string, user);
		} else
			System.out.println("Pogresan unos");
	}

	public void changeUsername(String newUsername, User user) {
		user.setUsername(newUsername);
	}

	public void changePassword(String newPassword, User user) {
		char[] password = newPassword.toCharArray();
		user.setPassword(password);
	}

	public void deleteUser(User user) {
		users.remove(user);
	}

	public List<User> getUsers() {
		return users;
	}

	public UserManipulation(List<User> users) {
		super();
		this.users = users;
		users.add(new User("Cenak", "Cenakovic", "admin", new char[] { 'a', 'b', 'c', 'd', 1, 3, 4 }, Role.ADMIN));
	}

}
