package eventnix.common.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Login {
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column(name = "user_type")
	private String userType;

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	

}
