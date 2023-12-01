package ZenFit.dao;

import java.sql.SQLException;
import java.util.List;

import ZenFit.classes.WorkoutLog;

public interface WorkoutLogDAO {
	List<WorkoutLog> viewWorkoutLog(int id) throws SQLException;
	boolean addWorkoutLog(WorkoutLog workout) throws SQLException;
	boolean deleteWorkoutLog(int id) throws SQLException;
}
