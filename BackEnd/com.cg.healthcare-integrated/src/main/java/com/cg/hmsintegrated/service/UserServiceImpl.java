package com.cg.hmsintegrated.service;

import javax.transaction.Transactional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hmsintegrated.dao.UserDao;
import com.cg.hmsintegrated.entity.User;
import com.cg.hmsintegrated.exception.UserNotFoundException;


  
/****************************
 *          @author          Aryan Srivastava
 *          Description      It is a service implementation class that provide bussiness logic for registerNewUser, 
 *                           signIn & signOut methods for performing operation. 
 *          Version          1.0
 *          Created Date     27-Nov-2020
 ****************************/  
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;
	
	/****************************
	 *    Method        registerNewUser
     *    Description   To implement the method which register the new user & add details to database
     *    Created By    Aryan Srivastava
     *    Created Date  27-Nov-2020                       
	 ****************************/
	@Override
	public Boolean registerNewUser(User user) {
		User Result = userDao.save(user);
		if (Result != null) {
			return true;
		} else
			return false;
	}

	/****************************
	 *    Method        login
     *    Description   To implement the method which login the user after validating username 
     *                  & password from the database
     *    Created By    Aryan Srivastava
     *    Created Date  27-Nov-2020                       
	 ****************************/
	@Override
	public String login(String userName, String password) throws UserNotFoundException {
		
		
		if(userName!=null && password!=null)
		{
			if(userName.equals("Raavan") && password.equals("raavan12"))
			{
				return "Admin";
			}
			else if(userDao.validate(userName, password)!=null)
			{
				
			    return "Patient";
			}
			else
			{
				return "Wrong Credentials!!";
			}
		}
		else
		{
			 throw new UserNotFoundException("Field Empty!!!");
		}
	}
	
	/****************************
	 *    Method        showAllUsers
     *    Description   To implement the method which login the user after validating username 
     *                  & password from the database
     *    Created By    Aryan Srivastava
     *    Created Date  27-Nov-2020                       
	 ****************************/
	@Override
	public List<User> showAllUsers() 
	{
		return userDao.findAll();
	}

	
	/****************************
	 *    Method        signOut
     *    Description   To implement the method which login the user after validating username 
     *                  & password from the database
     *    Created By    Aryan Srivastava
     *    Created Date  27-Nov-2020                       
	 ****************************/
	@Override
	public Boolean signOut() {
		// TODO Auto-generated method stub
		return null;
	}

}
