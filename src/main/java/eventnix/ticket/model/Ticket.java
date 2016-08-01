package eventnix.ticket.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import eventnix.person.model.Person;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ticketId;
	
	@Column
	private long userId;
	
	@Column
	private int eventId;
	
	@Column
	private int amount;
	
	@Column
	private int ticketsBooked;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String transactionNumber;
	
	@Column
	private String ticketdate;

	@Column
	private String status;
	
		@Transient
		private String firstName;
		@Transient
		private String lastName;
		@Transient
		private String email;
		@Transient
		 private String phone;
		@Transient
		private int amountPaid;
		
		
	public int getAmountPaid() {
			return amountPaid;
		}

		public void setAmountPaid(int amountPaid) {
			this.amountPaid = amountPaid;
		}

	public String getFirstName() {
	return firstName;
}

	

public String getTicketdate() {
		return ticketdate;
	}

	public void setTicketdate(String ticketdate) {
		this.ticketdate = ticketdate;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTicketsBooked() {
		return ticketsBooked;
	}

	public void setTicketsBooked(int ticketsBooked) {
		this.ticketsBooked = ticketsBooked;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getattendersListJson(){
		StringBuilder builder = new StringBuilder();
		builder.append("{").
		
			append("\"firstname\": \"").append(getFirstName()).append("\" , ").
			append("\"lastname\": \"").append(getLastName()).append("\" , ").
			append("\"email\": \"").append(getEmail()).append("\" , ").
			append("\"phone\": \"").append(getPhoneNumber()).append("\" , ").
			append("\"tickets\": \"").append(getTicketsBooked()).append("\" , ").
			append("\"amount\": \"").append(getAmount()).append("\", ").
			append("\"amountPaid\": \"").append(getAmountPaid()).append("\"").
			append("}");
		return builder.toString();
	}

	public String getTicketsSoldPerDayJSN(){
		StringBuilder builder = new StringBuilder();
		builder.append("{").
		
			append("\"TicketsBooked\": \"").append(getTicketsBooked()).append("\" , ").
			append("\"amount\": \"").append(getAmountPaid()).append("\" , ").
			append("\"ticketdate\": \"").append(getTicketdate()).append("\" ").
			
			append("}");
		return builder.toString();
	}

}
