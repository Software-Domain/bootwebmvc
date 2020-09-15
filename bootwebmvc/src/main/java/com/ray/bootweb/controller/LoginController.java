package com.ray.bootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ray.bootweb.bean.User;
import com.ray.bootweb.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
    LoginService service;
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping(value="/login")
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

        boolean isValidUser = service.validateUser(name, password);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

        model.put("name", new User(name,password));

        return "welcome";
    }
}
