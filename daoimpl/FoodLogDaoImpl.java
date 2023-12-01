package ZenFit.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ZenFit.classes.FoodLog;
import ZenFit.dao.FoodLogDAO;
import ZenFit.util.DbConnection;

public class FoodLogDaoImpl implements FoodLogDAO{
	  private static final String SELECT_ALL_QUERY = "SELECT * FROM foodLog where userId=(?)";
	  private static final String DELETE_QUERY = "DELETE FROM foodLog WHERE fLogId=?";  
	  private static final String INSERT_QUERY = "INSERT INTO foodLog (userId, date, description, calories) VALUES (?, ?, ?, ?)";
	  @Override
	public List<FoodLog> viewFoodLog(int id) throws SQLException {
		Connection con = DbConnection.getConnection();
        List<FoodLog> foodLogs = new ArrayList<>();
		PreparedStatement st = con.prepareStatement(SELECT_ALL_QUERY);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();

        while (rs.next()) {
            FoodLog foodLog = new FoodLog();
            
            foodLog.setId(rs.getInt("fLogId"));
            foodLog.setUserId(rs.getInt("userId"));
            foodLog.setDate(rs.getDate("date"));
            foodLog.setDescription(rs.getString("description"));
            foodLog.setCalories(rs.getInt("calories"));

            foodLogs.add(foodLog);
        }
        return foodLogs;
	}

	@Override
	public boolean addFoodLog(FoodLog food) throws SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement(INSERT_QUERY);

            st.setInt(1, food.getUserId());
            st.setDate(2, food.getDate());
            st.setString(3, food.getDescription());
            st.setInt(4, food.getCalories());

            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
	}

	@Override
	public boolean deleteFoodLog(int id) throws SQLException {
		Connection con = DbConnection.getConnection();
        PreparedStatement st = con.prepareStatement(DELETE_QUERY);

        st.setInt(1, id);

        int rowsAffected = st.executeUpdate();
        return rowsAffected > 0;
	}

}
