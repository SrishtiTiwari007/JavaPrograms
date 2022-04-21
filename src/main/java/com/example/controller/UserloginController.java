package com.example.controller;

import java.util.Optional;

import org.apache.catalina.startup.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.userlogin;
import com.example.demo.userrepo;

@Controller
public class UserloginController {
	@Autowired
	userrepo urepo;

@GetMapping("/l")
public String login(Model model) {
	userlogin usr=new userlogin();
	model.addAttribute("user",usr);
	return "login";
}
@RequestMapping(value="/userlogin",method=RequestMethod.POST)
public String loginuser(@ModelAttribute("user") userlogin user) {
	
	String id=user.getUserId();
	Optional<userlogin> userdata=urepo.findById(id);
	if(user.getPassword().equals(userdata.get().getPassword())){
	return "home";
}
	
else {
	return "error";
}
}
}