package com.example.controller;

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

import com.example.demo.medicines;
import com.example.demo.medicinesService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    medicinesService service;
    @RequestMapping("/getmedicines/{id}")
    public ResponseEntity<medicines> findmed(@PathVariable(value="id")Integer id) {
    	try {
    		medicines med=service.findById(id);
    	if(med !=null) {
    		return new ResponseEntity<>(med,HttpStatus.OK);
    		
    	}
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}
    	
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @RequestMapping("/getmedicinesbyname/{medname}")
    public ResponseEntity<medicines> findmednme(@PathVariable(value="medname")String medname) {
    	try {
    		medicines mednme=service.findBymedname(medname);
    	if(mednme !=null) {
    		return new ResponseEntity<>(mednme,HttpStatus.OK);
    		
    	}
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}
    	
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @RequestMapping("/getmedicinesbytype/{medtype}")
     List<medicines> findmedtyp(@PathVariable(value="medtype")String medtype) throws Exception {
    	try {
    	List<medicines> medtyp=service.findBymedtype(medtype);
    	if(medtyp !=null) {
    		return medtyp;
    	}
    	else {
    		return null;
    	}	
    }
    catch (InternalServerError ex) {
    throw new Exception("INTERNAL_SERVER_ERROR");
    }
    }
    @GetMapping("/getmedicineslist")
    List<medicines> listEmployee() throws Exception{
    	try {
    	List<medicines> medlist=service.fetchMedicineList();
        for(medicines m:medlist)
        	System.out.println(m+"\n");
        return medlist;
    
    }catch (InternalServerError ex) {
    	throw new Exception("INTERNAL_SERVER_ERROR");
    }
    }
    
    @PostMapping("/save")
    public ResponseEntity<medicines> savemed(@RequestBody medicines m){
    	try {
    	service.savemed(m);
    	return new ResponseEntity<medicines>(m,HttpStatus.OK);
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
   @PutMapping("/update")
    public ResponseEntity<medicines> updatem(@RequestBody medicines m){
    	try{
    		service.updateMedicines(m,m.getMedid());
    	
    	return new ResponseEntity<medicines>(m,HttpStatus.OK);
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }}
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<medicines> deletemedicinesById(@PathVariable("id") int id){
    	try{
    		medicines m=service.deletemedById(id);
    	
    	return new ResponseEntity<medicines>(m,HttpStatus.OK);
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }}
    @GetMapping("/getmedicinesort") 
	   List<medicines> listmedicinesorted() throws Exception{
    try {
    	List<medicines> med=service.SortMedicinesByname();
        for(medicines m:med)
        	System.out.println(m+"\n");
        return med;
    
    }catch(InternalServerError ex) {
    	throw new Exception("INTERNAL_SERVER_ERROR");
    }}
	  
		@GetMapping("/map")
		public HashMap<String,Integer> maps()
		{
			HashMap<String,Integer> map=service.counttype();
			return map;
		}
}
