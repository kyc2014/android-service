package com.abroad.studies.controller;


import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.abroad.studies.mail.MailSender;
import com.abroad.studies.model.User;
import com.abroad.studies.service.UserService;
import com.abroad.studies.util.PasswordUtil;

@Controller
public class MainController {

	private UserService userService;

	private static final Logger logger = LoggerFactory
			.getLogger(MainController.class);

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setPersonService(UserService ps) {
		this.userService = ps;
	}

	// For add and update person both
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(@ModelAttribute("UserModel") User user) {
		String returnJSON = "";
		long timestamp = 0L;
		try {
			if(!PasswordUtil.isEmptyString(user.getName())){
				if(PasswordUtil.isValidEmail(user.getEmail())){
					if (this.userService.getUserByEmail(user.getEmail()) == null) {
						user.setTimestamp(timestamp);
						user.setMailFlag(0);
						user.setStatus("Not Activated");
						user.setActId(PasswordUtil.generateUUID());
						userService.addUser(user);
						MailSender.Send(user);
						returnJSON = "{status:success,message:User added}";
					} else {
						returnJSON = "{status:error,message: Email ID already exsists}";
					}
				}
				else{
					returnJSON = "{status:error,message: Invalid Email}";
				}
			}
			else{
				returnJSON = "{status:error,message: Invalid Name}";
			}
		} catch (NoSuchAlgorithmException nsae) {
			logger.error("Unable to Hash", nsae);
			returnJSON = "{status:error, meesage:Service is temporarily unavailable}";
		}
		return returnJSON;
	}
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(@ModelAttribute("UserModel") User user) {
		String returnJSON = "";
		long timestamp = 0L;
		try {
			if (this.userService.getUserByEmail(user.getEmail()) == null) {
				user.setTimestamp(timestamp);
				user.setMailFlag(0);
				user.setStatus("Not Activated");
				user.setActId(PasswordUtil.generateUUID());
				userService.addUser(user);
				returnJSON = "{status:success,message:User added}";
				MailSender.Send(user);
			} else {
				returnJSON = "{status:error,message: Email ID already exsists}";
			}
		} catch (NoSuchAlgorithmException nsae) {
			logger.error("Unable to Hash", nsae);
			returnJSON = "{status:error, meesage:Service is temporarily unavailable}";
		}catch(Exception ex){
			logger.error("Must be with email "+ex+" check the User Email "+ user.getEmail());
		}
		return returnJSON;
	}

	@RequestMapping(value = "/user/activate/{actId}", method = RequestMethod.POST)
	@ResponseBody
	public String activate(@PathVariable String actId) {
		String returnJSON = "";
		User userModelFromDB = this.userService.getUserByActId(actId);
		if (userModelFromDB != null && userModelFromDB.getTimestamp() != 0 && "Not Activated".equalsIgnoreCase(userModelFromDB.getStatus())) 
		{				
			userModelFromDB.setActId(PasswordUtil.generateUUID());
			userModelFromDB.setStatus("Activated");
			java.util.Date date= new java.util.Date();
			userModelFromDB.setTimestamp(date.getTime());
			userService.updateUser(userModelFromDB);
			returnJSON = "{status:success,message:User Activated}";
		} else {
			returnJSON = "{status:error,message: Invalid Activation Code}";
		}
		return returnJSON;
	}

}
