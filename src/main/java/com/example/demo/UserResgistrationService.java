package com.example.demo;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserResgistrationService {

	USER1 UpdateDetails(USER1 u, int id);

	//void save(USER1 ar);
	USER1 findById(int id);
	List<USER1>fetchUSER1List();
	HashMap<String,String> usertype(String name);
	HashMap<String,String> userage(String name,String medname);
    HashMap<String,String> medorder() throws ParseException;
    //kalyan
    USER1 addCustomer(USER1 c);
	USER1 deleteCustomer(Integer id);
	USER1 updateCustomer(Integer id, USER1 c);
	int getbill(String medname);
	double getmanybill(int id);
	
	USER1 deleteUserById(Integer id);

	List<USER1> Sortbyname();
	userlogin add(userlogin u);
	String updatepwd(String userid,userlogin u1);
}