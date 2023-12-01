package ZenFit.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ZenFit.classes.WorkoutLog;
import ZenFit.dao.WorkoutLogDAO;
import ZenFit.util.DbConnection;

public class WorkoutLogDaoImpl implements WorkoutLogDAO{
	private static final String INSERT_QUERY = "INSERT INTO workoutLog (userId, date,name,intensity, time, reps,category,calories) VALUES (?, ?, ?, ?,?,?,?,?)";
	 private static final String SELECT_QUERY= "SELECT * FROM workoutLog where userId=(?)";
	 private static final String DELETE_QUERY = "DELETE FROM workoutLog WHERE wLogId=?";

	@Override
	public List<WorkoutLog> viewWorkoutLog(int id) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement(SELECT_QUERY);
		List<WorkoutLog> li=new ArrayList<WorkoutLog>();
		st.setInt(1,id);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			WorkoutLog workout=new WorkoutLog();
			workout.setId(rs.getInt("wLogId"));
			workout.setUserId(rs.getInt("userId"));
	        workout.setDate(rs.getDate("date"));
	        workout.setName(rs.getString("name"));
	        workout.setIntensity(rs.getString("intensity"));
	        workout.setTime(rs.getInt("time"));
	        workout.setReps(rs.getInt("reps"));
	        workout.setCategory(rs.getString("category"));
	        workout.setCalories(rs.getInt("calories"));
	        li.add(workout);
		}
		return li;
	}

	@Override
	public boolean addWorkoutLog(WorkoutLog workout) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement(INSERT_QUERY);

        st.setInt(1, workout.getUserId());
        st.setDate(2, workout.getDate());
        st.setString(3, workout.getName());
        st.setString(4, workout.getIntensity());
        st.setInt(5, workout.getTime());
        st.setInt(6, workout.getReps());
        st.setString(7, workout.getCategory());
        st.setInt(8, workout.getCalories());
        
		return st.executeUpdate()>0;
	}

	@Override
	public boolean deleteWorkoutLog(int id) throws SQLException {
		 Connection con = DbConnection.getConnection();
	     PreparedStatement st = con.prepareStatement(DELETE_QUERY);
	     st.setInt(1,id);
	     int rowsAffected = st.executeUpdate();
	        return rowsAffected > 0;
	}

}
