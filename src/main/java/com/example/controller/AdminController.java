package com.example.controller;
/*import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.example.demo.USER1;
import com.example.demo.UserResgistrationService;
import com.example.demo.medicines;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    UserResgistrationService serv;
    @GetMapping("/getuserlist")
    List<USER1> getuser() throws Exception{
    	try {
    	List<USER1> user=serv.fetchUSER1List();
        for(USER1 i :user)
        	System.out.println(i+"\n");
        return user;
    
    }catch (InternalServerError ex) {
    	throw new Exception("INTERNAL_SERVER_ERROR");
    }
    }
	@RequestMapping("/getuser/{id}")
    public ResponseEntity<USER1> findmed(@PathVariable(value="id")Integer id) {
    	try {
    		USER1 usr=serv.findById(id);
    	if(usr !=null) {
    		return new ResponseEntity<>(usr,HttpStatus.OK);
    		
    	}
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}
    	
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
	@GetMapping("/medorder")
	public HashMap<String,String> order() throws Exception {
		   try {
			   HashMap<String,String> s=serv.medorder();
			return s;
		   }catch(Exception ex) {
			   throw new Exception("INTERNAL_SERVER_ERROR");
		   }
	   }
	@GetMapping("/usersort")
	List<USER1> UserSortByname() throws Exception{
		try {
			List<USER1> dev=serv.Sortbyname();
			
		for(USER1 d:dev) {
			System.out.println(d+"\n");}
		
		return dev;
		
	}catch(InternalServerError ex) {
		throw new Exception("INTERNAL_SERVER_ERROR");
	}
	}
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<USER1> deletebyid(@PathVariable(value="id") Integer id){
			USER1 p=serv.deleteUserById(id);
			return new ResponseEntity<USER1>(p,HttpStatus.OK);
	}}
	*/
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.USER1;
import com.example.demo.UserResgistrationService;
import com.example.demo.medicines;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    UserResgistrationService serv;
	@RequestMapping("/getuser/{id}")
    public ResponseEntity<USER1> finduser(@PathVariable(value="id")Integer id) {
    	
    		USER1 usr=serv.findById(id);
    	if(usr !=null) {
    		return new ResponseEntity<>(usr,HttpStatus.OK);
    		
    	}
    	
    	else {
    		
    		throw new ResourceNotFoundException();
    		
    	}
	
    
    }
	@GetMapping("/usertype/{name}")
	public HashMap<String,String> usrtype(@PathVariable(value="name")String name) throws Exception {
		   try {
			   HashMap<String,String> s=serv.usertype(name);
			return s;
		   }catch(Exception ex) {
			   throw new Exception("INTERNAL_SERVER_ERROR");
		   }
	   }
	@GetMapping("/medorder")
	public HashMap<String,String> order() throws Exception {
		   try {
			   HashMap<String,String> s=serv.medorder();
			return s;
		   }catch(Exception ex) {
			   throw new Exception("INTERNAL_SERVER_ERROR");
		   }
	   }
	@GetMapping("/sort")
	List<USER1> UserSortByname() throws Exception{
		try {
			List<USER1> dev=serv.Sortbyname();
			
		for(USER1 d:dev) {
			System.out.println(d+"\n");}
		
		return dev;
		
	}catch(InternalServerError ex) {
		throw new Exception("INTERNAL_SERVER_ERROR");
	}
	}
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<USER1> deletebyid(@PathVariable(value="id") Integer id){
			
			USER1 p=serv.deleteUserById(id);
			if(p !=null) {
	    		return new ResponseEntity<>(p,HttpStatus.OK);
	    		
	    	}
	    	else {
	    		new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	    		throw new ResourceNotFoundException();
	    	}
			
			
	
			
	}
	
	
	
}


		//can go to inventory Controller
	
	

	

