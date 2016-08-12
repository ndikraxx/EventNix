package eventnix.event.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private String venue;

	@Column
	private String price;

	@Column
	private String category;

	@Column(length = 6000)
	private String description;

	@Column
	private String status;

	@Column
	private int tickets;

	@Column
	private String imageName;

	@Column(columnDefinition = "DATETIME")
	private String startDateTime;

	@Column(columnDefinition = "DATETIME")
	private String endDateTime;

	@Column
	long userId;

	@Column(columnDefinition = "DATETIME")
	private String postedDateTime;

	@Column
	private int remainingTickets;

	public int getRemainingTickets() {
		return remainingTickets;
	}

	public void setRemainingTickets(int remainingTickets) {
		this.remainingTickets = remainingTickets;
	}

	public String getPostedDateTime() {
		return postedDateTime;
	}

	public void setPostedDateTime(String postedDateTime) {
		this.postedDateTime = postedDateTime;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEvent() {
		StringBuilder builder = new StringBuilder();
		builder.append("{").append("\"id\": \"").append(getId())
				.append("\" , ").append("\"name\": \"").append(getName())
				.append("\" , ").append("\"venue\": \"").append(getVenue())
				.append("\" , ").append("\"price\": \"").append(getPrice())
				.append("\" , ").append("\"category\": \"").append(getCategory()).append("\" , ")
				.append("\"description\": \"").append(getDescription()).append("\", ")
				.append("\"status\": \"").append(getStatus())
				.append("\", ").append("\"ticketsAvailable\": \"")
				.append(getTickets()).append("\", ")
				.append("\"ticketsRemaining\": \"")
				.append(getRemainingTickets()).append("\", ")
				.append("\"imageName\": \"").append(getImageName())
				.append("\", ").append("\"startDate\": \"")
				.append(getStartDateTime()).append("\", ")
				.append("\"endDate\": \"").append(getEndDateTime())
				.append("\", ").append("\"timePosted\": \"")
				.append(getPostedDateTime()).append("\", ")
				.append("\"userId\": \"").append(getUserId()).append("\"")
				.append("}");
		return builder.toString();
	}
	
	public String ticketSoldJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("{").append("\"label\": \"").append(getTickets()).append("\" , ").
		append("\"val\": \"").append(getName())
				.append("\" , ").append("\"venue\": \"").append(getVenue())
				.append("\" , ").append("\"price\": \"").append(getPrice())
				.append("\" , ").append("\"category\": \"").append(getCategory()).append("\" , ")
				.append("\"description\": \"").append(getDescription()).append("\", ")
				.append("\"status\": \"").append(getStatus())
				.append("\", ").append("\"ticketsAvailable\": \"")
				.append(getTickets()).append("\", ")
				.append("\"ticketsRemaining\": \"")
				.append(getRemainingTickets()).append("\", ")
				.append("\"imageName\": \"").append(getImageName())
				.append("\", ").append("\"startDate\": \"")
				.append(getStartDateTime()).append("\", ")
				.append("\"endDate\": \"").append(getEndDateTime())
				.append("\", ").append("\"timePosted\": \"")
				.append(getPostedDateTime()).append("\", ")
				.append("\"userId\": \"").append(getUserId()).append("\"")
				.append("}");
		return builder.toString();
	}
	public String listofEvents(){
		StringBuilder builder = new StringBuilder();
		builder.append("{").append("\"eventName\": \"").append(getName()).append("\"  ").
		append("}");
			
		return builder.toString();
		
	}

}
