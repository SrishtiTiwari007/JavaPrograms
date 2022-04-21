package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.USER1;
import com.example.demo.UserResgistrationService;
import com.example.demo.userlogin;

@RestController
@RequestMapping("/form")
public class RegistrationController {
	
		@Autowired
	    UserResgistrationService ser;
		
		@RequestMapping("/Register")
		public String home() {
			String s="Welcome to our PharmacyStor"+"\nRegister to get your med"+"\nKindly follow the steps";
			return s;
		}
		@RequestMapping("/SignUp")
	    public ResponseEntity<userlogin> signup(@RequestBody userlogin u1){
	    	try {
	    	ser.add(u1);
	    	return new ResponseEntity<userlogin>(u1,HttpStatus.OK);
	    }catch (Exception ex) {
	    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    }
		/*@PostMapping("/step1")
		public ResponseEntity<USER1> save(@RequestBody USER1 a){
			USER1 ar=a;
	        ser.save(ar);
			return new ResponseEntity<USER1>(ar,HttpStatus.OK);
		}*/
		@GetMapping("/usertype/{name}")
		public HashMap<String,String> usrtype(@PathVariable(value="name")String name) throws Exception {
			   try {
				   HashMap<String,String> s=ser.usertype(name);
				return s;
			   }catch(Exception ex) {
				   throw new Exception("INTERNAL_SERVER_ERROR");
			   }
		   }
		@GetMapping("/step2")
		public String register() {
			String s="Registration Successfull\n Fill the following details \n "
					+ " email:\r\n"
					+ " gender:\r\n"
					+ " age;\r\n"
					+ " pnum:\r\n"
					+ " name:";
			return s;	
		}
		
		@PutMapping("/forgotpassword/{userid}")
		public String update(@PathVariable(value="userid") String userid,@RequestBody userlogin ct){
			String s=ser.updatepwd(userid, ct);
			return s;
		}
		
		//After this User login Controller
}