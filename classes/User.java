package ZenFit.classes;

public class User {
	
	private String username;
	private String password;
	private int userId;
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {}
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
	public int getUserId() {
		// TODO Auto-generated method stub
		return this.userId;
	}
	public void setUserId(int id)
	{
		this.userId=id;
	}

}
