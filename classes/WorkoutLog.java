package ZenFit.classes;

import java.sql.Date;

public class WorkoutLog {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private Date date;
	private String name;
	private String intensity;
	private String category;
	private int time;
	private int reps;
	private int calories;
	private int userId;
	
	public WorkoutLog() {}
	public void setCategory(String category) {
		this.category = category;
	}
	public WorkoutLog(Date date, String name, String intensity, int time, int reps, int calories, int userId,String category) {
		super();
		this.date = date;
		this.name = name;
		this.intensity = intensity;
		this.time = time;
		this.reps = reps;
		this.calories = calories;
		this.userId = userId;
		this.category=category;
		System.out.println(category);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntensity() {
		return intensity;
	}
	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}

}
