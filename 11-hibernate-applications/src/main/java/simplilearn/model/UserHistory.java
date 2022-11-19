package simplilearn.model;

import java.util.Date;

public class UserHistory {
	
	private int id;
	private User user;
	
	private Date entryTime;
	private String entry;
	
	public UserHistory() {
		super();//constructor for users who don't create a history
	}
	
	public UserHistory(Date entryTime, String entry) {
		this.entryTime = entryTime;
		this.entry = entry;
	}
//Getter & Setter methods will be used by Hibernate internally
//when it uses the <property> element (to map it with the db table) 
//in the {class}.hbm.xml
	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
