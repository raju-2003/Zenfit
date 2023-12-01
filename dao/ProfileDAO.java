package ZenFit.dao;

import java.sql.SQLException;

import ZenFit.classes.Profile;

public interface ProfileDAO {
	Profile getProfileById(int id) throws SQLException;
	boolean addProfile(Profile p) throws SQLException;
	boolean updateProfile(int userId,Profile p) throws SQLException;

}
