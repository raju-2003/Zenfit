package ZenFit.dao;

import java.sql.Date;
import java.sql.SQLException;

import ZenFit.classes.Goals;

public interface GoalsDAO {
	boolean addGoal(Goals g) throws SQLException;
	Goals viewGoal(int userId);

	boolean updateGoal(int userId) throws SQLException;
	boolean updateWeight(double weight,int userId) throws SQLException;
	int viewNetCalories(Date date, int userId) throws SQLException;
}
