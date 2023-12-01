package ZenFit.classes;

public class Goals {
	private int userId;
	private double currentWeight;
	private double goalWeight;
	private double startFat;
	private double targetFat;
	private double startCalories;
	private double targetCalories;
	private double rateOfWeightChange;
	
	public double getRateOfWeightChange() {
		return rateOfWeightChange;
	}
	public void setRateOfWeightChange(double rateOfWeightChange) {
		this.rateOfWeightChange = rateOfWeightChange;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(double currentWeight) {
		this.currentWeight = currentWeight;
	}
	public double getGoalWeight() {
		return goalWeight;
	}
	public void setGoalWeight(double goalWeight) {
		this.goalWeight = goalWeight;
	}
	public double getStartFat() {
		return startFat;
	}
	public void setStartFat(double startFat) {
		this.startFat = startFat;
	}
	public double getTargetFat() {
		return targetFat;
	}
	public void setTargetFat(double targetFat) {
		this.targetFat = targetFat;
	}
	public double getStartCalories() {
		return startCalories;
	}
	public void setStartCalories(double startCalories) {
		this.startCalories = startCalories;
	}
	public double getTargetCalories() {
		return targetCalories;
	}
	public void setTargetCalories(double targetCalories) {
		this.targetCalories = targetCalories;
	}
	public Goals(double currentWeight, double startFat, double targetFat, double startCalories) {
		super();
		this.currentWeight = currentWeight;
		this.startFat = startFat;
		this.targetFat = targetFat;
		this.startCalories = startCalories;
		goalWeight=currentWeight-currentWeight*(startFat-targetFat)/100;
		rateOfWeightChange=currentWeight*(startFat-targetFat)/10;
		targetCalories=startCalories-(currentWeight*10);
	}
}
