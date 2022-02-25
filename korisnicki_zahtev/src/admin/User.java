package admin;

import java.util.Arrays;
import java.util.Objects;

public class User {

	private final String name;
	private final String surname;
	private final String username;
	private final char[] password;
	private final Role role;
	public User(String name, String surname, String username, char[] password, Role role) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getUsername() {
		return username;
	}
	public char[] getPassword() {
		return password;
	}
	public Role getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + ", surname=" + surname + ", username=" + username +  ", role=" + role + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + Objects.hash(name, role, surname, username);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name) && Arrays.equals(password, other.password) && role == other.role
				&& Objects.equals(surname, other.surname) && Objects.equals(username, other.username);
	}
	
	
}
