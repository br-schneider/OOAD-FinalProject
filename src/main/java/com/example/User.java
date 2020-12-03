
public class User {
	private String user;
	private String password;
	private String favorites;

	public void setUser(String user) {
		this.user = user;
	}
	public String getUser() {
		return user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setFavorites(String favorites) {
		this.favorites = favorites;
	}
	public String getFavorites() {
		return favorites;
	}
	
	@Override
	public String toString() {
		return "User [User=" + user + "]";
	}
}
