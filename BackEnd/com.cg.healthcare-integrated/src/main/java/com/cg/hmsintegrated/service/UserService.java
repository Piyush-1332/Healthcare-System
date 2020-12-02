package com.cg.hmsintegrated.service;

import java.util.List;

import com.cg.hmsintegrated.entity.User;
import com.cg.hmsintegrated.exception.UserNotFoundException;

/****************************
 * @author Aryan Srivastava Description It is a service interface that provide
 *         the methods for adding new customer & login user and further
 *         implemented by service implementation Version 1.0 Created Date
 *         26-Nov-2020
 ****************************/
public interface UserService {

	/****************************
	 * Method registerNewUser Description define the method Created By Aryan
	 * Srivastava Created Date 26-Nov-2020
	 ****************************/
	Boolean registerNewUser(User user);

	/****************************
	 * Method login Description define the method Created By Aryan Srivastava
	 * Created Date 26-Nov-2020
	 ****************************/
	String login(String userName, String password) throws UserNotFoundException;

	/****************************
	 * Method showAllUsers Description define the method Created By Aryan Srivastava
	 * Created Date 26-Nov-2020
	 ****************************/
	List<User> showAllUsers();

	/****************************
	 * Method signOut Description define the method Created By Aryan Srivastava
	 * Created Date 26-Nov-2020
	 ****************************/
	Boolean signOut();

}
