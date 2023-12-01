package ZenFit.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ZenFit.classes.Goals;
import ZenFit.dao.GoalsDAO;
import ZenFit.util.DbConnection;

public class GoalsDaoImpl implements GoalsDAO{
	private static final String INSERT_QUERY = "INSERT INTO goals (userId, currentWeight,goalWeight,startFat, goalFat, rateOfWeightChange,startCalories,targetCalories) VALUES (?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM goals";
	private static final String SELECT_TARGET_CALORIES = "SELECT targetCalories FROM goals where userId=?";
	private static final String UPDATE_WEIGHT_QUERY = "UPDATE goals SET currentWeight=? WHERE userId=?";
	private static final String UPDATE_QUERY = "UPDATE goals SET currentWeight=?,goalWeight=?,startFat=?, goalFat=?, rateOfWeightChange=?,startCalories=?,targetCalories=?  WHERE userId=?";
	private static final String DIFF_QUERY = "SELECT COALESCE(foodCalories, 0) - COALESCE(workoutCalories, 0) AS calorieDifference " +
            "FROM ( " +
            "    SELECT SUM(calories) AS workoutCalories " +
            "    FROM workoutLog " +
            "    WHERE userId = ? AND date = ? " +
            ") AS workout, " +
            "( " +
            "    SELECT SUM(calories) AS foodCalories " +
            "    FROM foodLog " +
            "    WHERE userId = ? AND date = ? " +
            ") AS food";
	@Override
	public boolean addGoal(Goals goal) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement(INSERT_QUERY);
		st.setInt(1, goal.getUserId());
		st.setDouble(2, goal.getCurrentWeight());
		st.setDouble(3, goal.getGoalWeight());
		st.setDouble(4, goal.getStartFat());
		st.setDouble(5, goal.getTargetFat());
		st.setDouble(6, goal.getRateOfWeightChange());
		st.setDouble(7, goal.getStartCalories());
		st.setDouble(8, goal.getTargetCalories());
		
		return st.executeUpdate()>0;
	}

	@Override
	public Goals viewGoal(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateWeight(double weight,int userId) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement(UPDATE_WEIGHT_QUERY);
		st.setDouble(1, weight);
		st.setInt(2, userId);
		
		return st.executeUpdate()>0;
	}
	@Override
	public int viewNetCalories(Date date,int userId) throws SQLException
	{
		Connection con = DbConnection.getConnection();
		PreparedStatement st1 = con.prepareStatement(DIFF_QUERY);
		PreparedStatement st2 = con.prepareStatement(SELECT_TARGET_CALORIES);
		 st1.setInt(1, userId);
         st1.setDate(2, date);
         st1.setInt(3, userId);
         st1.setDate(4, date);
         st2.setInt(1, userId);
         ResultSet rs1=st1.executeQuery();
         ResultSet rs2=st2.executeQuery();
         while(rs1.next())
         {
        	 if(rs2.next())
        	 {
        		 if(rs1.getInt(1)==rs2.getInt(1))
        		 {
        			 System.out.println("\nYou are on the track "+rs1.getInt(1));
        			 return rs1.getInt(1);
        		 }
        		 else
        		 {
        			 System.out.println("\nDon't let your hopes down "+rs1.getInt(1));
        		 }
        			 
        	 }
         }
		return 0;
	}

	@Override
	public boolean updateGoal(int userId) throws SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		double weight=s.nextDouble();
		int startFat=s.nextInt();
		int targetFat=s.nextInt();
		int cal=s.nextInt();
		 Goals goal=new Goals(weight,startFat,targetFat,cal);
	      goal.setUserId(userId);
	  	Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement(UPDATE_QUERY);
		
		st.setDouble(1, goal.getCurrentWeight());
		st.setDouble(2, goal.getGoalWeight());
		st.setDouble(3, goal.getStartFat());
		st.setDouble(4, goal.getTargetFat());
		st.setDouble(5, goal.getRateOfWeightChange());
		st.setDouble(6, goal.getStartCalories());
		st.setDouble(7, goal.getTargetCalories());
		st.setInt(8, goal.getUserId());
		return st.executeUpdate()>0;
	}

	

}
