package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import admin.Role;
import admin.User;
import console.Login;
import util.UserManipulation;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		UserManipulation UM = new UserManipulation(new ArrayList<>());
		Login login = new Login(UM.getUsers());

		User currentUser = login.LogingIn();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		if (currentUser.getRole() == Role.ADMIN) {

			while (currentUser != null) {
				System.out.println("1)ADD User");
				System.out.println("2)Show all Users");
				System.out.println("3)Show User");
				System.out.println("4)Change User");
				System.out.println("5)Delete User");
				System.out.println("0)Log out");

				int k = Integer.parseInt(reader.readLine());

				System.out.println("=============================");
				switch (k) {
				case 0:
					currentUser =null;
					break;
				case 1:
					System.out.println("Write name:");
					String name = reader.readLine();
					System.out.println("Write surename:");
					String surename = reader.readLine();
					System.out.println("Write username:");
					String username = reader.readLine();
					System.out.println("Write password:");
					String password = reader.readLine();
					System.out.println("Write confirme password:");
					String password2 = reader.readLine();
					if(password.equals(password2))UM.insert(new User(name,surename,username,password.toCharArray(),Role.EDITOR));
					break;
				case 2:
					UM.showUsers();
					break;
				case 3:
					System.out.println("Write the name of the user:");
					String username2 = reader.readLine();
					UM.showUser(username2);
					break;
				case 4:
					UM.change(currentUser);
					break;
				case 5:
					UM.deleteUser(currentUser);
					break;
				}

			}
		} else {
			System.out.println("EDITOR NOT IMPLEMENTED");
		}
	}
}
