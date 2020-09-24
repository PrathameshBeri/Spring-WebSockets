package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	SecurityContext securityContext;
	
	@GetMapping("/")
	public String getHomeString(){
		
		return "home";
	}
	
	@GetMapping(value = "/admin")
	public void loginAdmin() {
		System.out.println("Hello Admin");
	}
	
	@GetMapping(value = "/user")
	public void loginUser() {
		System.out.println("Hello User");
	}
		
			
}  
