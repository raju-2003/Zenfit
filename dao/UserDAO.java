package ZenFit.dao;

import java.sql.SQLException;

import ZenFit.classes.User;

public interface UserDAO {
	boolean addUser(User u) throws SQLException;
	int verifyUser(String username,String password) throws SQLException;
}
