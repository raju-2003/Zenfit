package ZenFit.classes;

import java.sql.Date;

public class FoodLog {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private Date date;
	private int calories;
	private String description;
	private int userId;
	public FoodLog(Date date, int calories, String description, int userId) {
		super();
		this.date = date;
		this.calories = calories;
		this.description = description;
		this.userId = userId;
	}
	public FoodLog() {
		// TODO Auto-generated constructor stub
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
