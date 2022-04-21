package com.example.controller;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.example.demo.medicinesService;
import com.example.demo.USER1;
import com.example.demo.UserResgistrationService;
import com.example.demo.medicines;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
    @Autowired
    medicinesService service;
    @Autowired
    UserResgistrationService uservice;
    @RequestMapping("/Employee")
    public String tests() {
    	return "test employee1 controller";
    }
	   @GetMapping("/Checkstock")
	   public HashMap<String,String> chkstk() throws Exception {
		   try {
			   HashMap<String,String> s=service.checkStock();
			return s;
		   }catch(Exception ex) {
			   throw new Exception("INTERNAL_SERVER_ERROR");
		   }
	   }
		@GetMapping("/date/{medid}")
		public String date(@PathVariable(value="medid") Integer medid) throws ParseException
		{
			String d=service.checkexp(medid);
			return d;
		}
   
		@GetMapping("/expdatebyname")
		public HashMap<String,String> date(@RequestBody USER1 u) throws ParseException
		{
			HashMap<String,String> d=service.checkexpbyname(u);
			return d;
		}

		 @GetMapping("/userage/{name}/{medname}")
		public HashMap<String,String> usrtype(@PathVariable(value="name")String name,@PathVariable(value="medname")String medname) throws Exception {
				try {
					   HashMap<String,String> a=uservice.userage(name,medname);
					return a;
				   }catch(Exception ex) {
					   throw new Exception("INTERNAL_SERVER_ERROR");
				   }
			   }

			@GetMapping("/substitute/{medname}")
			public String sub(@PathVariable(value="medname") String medname)
			{
				String map=service.givesubstitute(medname);
				if(map!=null)
				return map;
				else
					return "no Substitute";
			}
		
			
			//After this Customer Controller
			

}
