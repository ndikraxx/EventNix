package eventnix.common.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name = "postal_box")
	private int postalBox;
	
	@Column(name = "postal_code")
	private int postalCode;
	
	@Column
	private String county;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPostalBox() {
		return postalBox;
	}

	public void setPostalBox(int postalBox) {
		this.postalBox = postalBox;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	
	
}
