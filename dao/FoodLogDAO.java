package ZenFit.dao;

import java.sql.SQLException;
import java.util.List;

import ZenFit.classes.FoodLog;

public interface FoodLogDAO {
	
	List<FoodLog> viewFoodLog(int id) throws SQLException;
	boolean addFoodLog(FoodLog food) throws SQLException;
	boolean deleteFoodLog(int id) throws SQLException;

}
