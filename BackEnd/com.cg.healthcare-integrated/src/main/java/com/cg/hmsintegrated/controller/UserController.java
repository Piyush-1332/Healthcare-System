package com.cg.hmsintegrated.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hmsintegrated.entity.User;
import com.cg.hmsintegrated.exception.UserException;
import com.cg.hmsintegrated.exception.UserNotFoundException;
import com.cg.hmsintegrated.service.UserService;

/****************************
 * @author Aryan Srivastava Description It is a controller class typically used
 *         in combination with annotated handler methods based on the mapping
 *         annotation Version 1.0 Created Date 24-Nov-2020
 ****************************/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	public UserService userService;

	/****************************
	 * Method registerNewUser Description To register the new user & add details to
	 * database
	 * 
	 * @throws UserException- It is raised if i'd present already in the database
	 *                        Created By Aryan Srivastava Created Date 24-Nov-2020
	 ****************************/
	@PostMapping("/registration")
	public ResponseEntity<String> registerNewUser(@Valid @RequestBody User user, BindingResult br)
			throws UserException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new UserException(err);
		}
		try {
			userService.registerNewUser(user);
			return new ResponseEntity<String>("Wow!!Regisstration Successful", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new UserException("ID already exists");
		}
	}

	/****************************
	 * Method login Description To login the user after validating username &
	 * password from the database
	 * 
	 * @throws UserNotFoundException- It is raised if i'd not present in the
	 *                                database Created By Aryan Srivastava Created
	 *                                Date 25-Nov-2020
	 ****************************/
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) throws UserNotFoundException {

		String userFound = userService.login(user.getUserName(), user.getPassword());
		return new ResponseEntity<String>(userFound, HttpStatus.OK);
	}

	/***************************************************************************************************************************
	 * Method getallUser Description To view all users and their details present in
	 * the database
	 * 
	 * @returns List:List of Users and their details Created By Aryan Srivastava
	 *          Created Date 25-Nov-2020
	 ***************************************************************************************************************************/
	@GetMapping("/viewalluser")
	public ResponseEntity<List<User>> getallUser() {
		List<User> userlist = userService.showAllUsers();
		return new ResponseEntity<List<User>>(userlist, HttpStatus.OK);

	}

}
