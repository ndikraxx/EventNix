package eventnix.person.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import eventnix.common.model.Address;
import eventnix.common.model.Login;
import eventnix.ticket.model.Ticket;

@Entity
@Embeddable
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name= "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column
	private String identification;
	
	@Column
	private String password;
	
	@Column(name = "user_type")
	private String userType;
	
	@Transient
	private String eventName;
	
	@Transient
	private String startDateTime;
	
	@Transient
	private String category;
	
	@Transient
	private int ticketsBooked;
	
	@Transient
	private int amount;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getTicketsBooked() {
		return ticketsBooked;
	}

	public void setTicketsBooked(int result) {
		this.ticketsBooked = result;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUserEventsJson(){
		StringBuilder builder = new StringBuilder();
		builder.append("{").
		
			append("\"EventName\": \"").append(getEventName()).append("\" , ").
			append("\"Category\": \"").append(getCategory()).append("\" , ").
			append("\"Tickets\": \"").append(getTicketsBooked()).append("\" , ").
			append("\"Amount\": \"").append(getAmount()).append("\" ").
			append("}");
		return builder.toString();
	}

	
	
}
