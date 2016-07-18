package eventnix.event.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String venue;
	
	@Column
	private String price;
	
	@Column
	private String category;
	
	@Column
	private String description;
	
	@Column 
	private String status;
	
	@Column 
	private  int tickets;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public String getEvent(){
		StringBuilder builder = new StringBuilder();
		builder.append("{").
			append("\"name\": \"").append(getName()).append("\" , ").
			append("\"venue\": \"").append(getVenue()).append("\" , ").
			append("\"price\": \"").append(getPrice()).append("\" , ").
			append("\"category\": \"").append(getCategory()).append("\" , ").
			append("\"description\": \"").append(getDescription()).append("\", ").
			append("\"status\": \"").append(getStatus()).append("\" ").
			append("}");
		return builder.toString();
	}



}
