package ocp;

public class Users implements Comparable<Users> {

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + "]";
	}
	@Override
	public int compareTo(Users	user) {
		
	return	this.username.compareTo(user.getUsername());
	
	}
}
