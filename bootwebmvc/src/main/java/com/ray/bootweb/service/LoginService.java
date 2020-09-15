package com.ray.bootweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.bootweb.bean.User;
import com.ray.bootweb.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepo;
	
	public boolean validateUser(String userid, String password) {
        //return userid.equalsIgnoreCase("maren") && password.equalsIgnoreCase("somers");
		User user = userRepo.findByUseridAndPassword(userid, password);
		if(user != null)
			return true;
		return false;
    }
}
