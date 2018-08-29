package co.grandcircus.Week6Capstone_UserList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	User user;
	String description;
	String dueDate;
	boolean isComplete;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public boolean getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public Item(Long id, User user, String description, String dueDate, boolean isComplete) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.dueDate = dueDate;
		this.isComplete = isComplete;
	}
	
	public Item() {

	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", user=" + user + ", description=" + description + ", dueDate=" + dueDate
				+ ", isComplete=" + isComplete + "]";
	}
	
	
	

}
