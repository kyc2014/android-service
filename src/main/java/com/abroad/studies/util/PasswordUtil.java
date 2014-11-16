package com.abroad.studies.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import org.apache.commons.validator.EmailValidator;


public class PasswordUtil {
	public static final String EMPTY_STRING = "";
	public static EmailValidator validator = EmailValidator.getInstance();
	
	public static String generateUUID() {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
        return uuid.toString();
	}
	public final static boolean isValidEmail(String target) {
		boolean flag = false;
	    	if (validator.isValid(target)) {
	    		   flag = true;
	    		} else {
	    		   flag = false;
	    		}
	    return flag;
	}
	public static final boolean isEmptyString(String target){
		boolean flag = false;
		if(target == null || EMPTY_STRING.equals(target.trim())){
			flag = true;
		}
		else{
			flag = false;
		}
		return flag;
	}
}
