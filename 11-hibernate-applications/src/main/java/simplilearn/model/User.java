package simplilearn.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	
	private List<UserHistory> history = new ArrayList<>();
	
	public List<UserHistory> getHistory() {
		return history;
	}
	
	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}
	
	public void addHistory(UserHistory historyItem) {
		historyItem.setUser(this);
		history.add(historyItem);
	}
	private ProteinData proteinData = new ProteinData();
	
	public ProteinData getProteinData(){
		return proteinData;
	}
	
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}
	
	public User() {
		super();
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

}
