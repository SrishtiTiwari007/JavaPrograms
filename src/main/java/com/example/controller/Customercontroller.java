package com.example.controller;

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

import com.example.demo.USER1;
import com.example.demo.UserResgistrationService;
import com.example.demo.medicines;

@RestController
@RequestMapping("/customer")
public class Customercontroller {
	
	@Autowired
	UserResgistrationService  cs;
	
	 @RequestMapping("/addcustomer")
	    public ResponseEntity<USER1> addcust(@RequestBody USER1 m){
	    	try {
	    	cs.addCustomer(m);
	    	return new ResponseEntity<USER1>(m,HttpStatus.OK);
	    }catch (Exception ex) {
	    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    }
	
	@PutMapping("/updatecust/{id}")
	public ResponseEntity<USER1> updatecust(@PathVariable(value="id")Integer id,@RequestBody USER1 ct){
		cs.updateCustomer(id, ct);
		return new ResponseEntity<USER1> (ct,HttpStatus.OK);
		
	}
	/*@DeleteMapping("/deletecust/{id}")
	public ResponseEntity<USER1> deletecust(@PathVariable(value="id")Integer id) {
		USER1 ci = cs.deleteCustomer(id);
	return new ResponseEntity<USER1> (ci,HttpStatus.OK);	
	}*/

	//After this Employee Controller
	
	@GetMapping("/bill/{id}")
	public double getmanybill(@PathVariable(value="id") Integer id) {
	return cs.getmanybill(id);
	}
	
}