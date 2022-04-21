package com.example.demo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class UserRegisterServiceImpl implements UserResgistrationService{
@Autowired
UserRepository repo;
@Autowired
medicinesRepository mrepo;
@Autowired
userrepo urepo;
USER1 u1;
@Override
public USER1 UpdateDetails(USER1 u,int id) 
{
	USER1 u1=repo.getById(id);
	u1.setName(u.getName());
	u1.setAge(u.getAge());
	u1.setGender(u.getGender());
	u1.setEmail(u.getEmail());
	u1.setMedname1(u.getMedname1());
	u1.setMedname2(u.getMedname2());
	u1.setMedname3(u.getMedname3());
	u1.setMedname4(u.getMedname4());
	u1.setMedname5(u.getMedname5());
	u1.setMed1qty(u.getMed1qty());
	u1.setMed2qty(u.getMed2qty());
	u1.setMed3qty(u.getMed3qty());
	u1.setMed4qty(u.getMed4qty());
	u1.setMed5qty(u.getMed5qty());
	repo.save(u1);
	return u1;

}

@Override
public USER1 findById(int id) {
	USER1 m= repo.getById(id);
	return m;
}
@Override
public List<USER1>fetchUSER1List(){
	List<USER1> list= repo.findAll();
	return list;
}
@Override
public HashMap<String,String> usertype(String name) {
	List<String> list= repo.findname();
	HashMap<String,String> map=new HashMap<>();
		if(list.contains(name) ) {
			map.put(name, "Existing customer. Now update the details");
		}
		else {
			map.put(name, "New customer. Now Enter the required details");
		}
		
	
	return map;
}
@Override
public HashMap<String,String> userage(String name,String medname) {
	List<Integer> list= repo.findage();
	List<String> l= repo.findname();
	List<medicines> al=mrepo.findAll();
	HashMap<String,Integer> ag=new HashMap<>();
	HashMap<String,Integer> map=new HashMap<>();
	HashMap<String,String> map1=new HashMap<>();
		int i=l.indexOf(name);
	    int a=list.get(i);
	    ag.put(name, a);
	    int aglimit=ag.get(name);
	    for(medicines j: al )
	    {
	    	map.put(j.getMedname(),j.getAgelimit());
	    }
	    if(map.containsKey(medname))
	    {
	    	if(map.get(medname)<=aglimit)
	    	{
	    		map1.put(name, "eligible");
	    	}
	    	else
	    		map1.put(name, "Not elligible. Underage");
	    }
	    else
	    	map1.put(name, "drug not present");
	    System.out.println(map.get(medname));
	  	return map1;
}

@Override
public HashMap<String, String> medorder()  {
	List<Date> list= mrepo.finddate();
	ArrayList<String> l=mrepo.findmedname();
	HashMap<String, String> order =new HashMap<>();
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDateTime now=LocalDateTime.now();
	for(int i=0;i<list.size();i++) {
		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy/MM/dd");
		Date dt1;
		try {
			
			Date dt2=objSDF.parse(dtf.format(now));
			if(list.get(i).compareTo(dt2)<0) {
				order.put(l.get(i),"medicine is out of date kindly reorder");
			}
			else {
				order.put(l.get(i),"medicine have date ");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return order;
}
@Override
public USER1 deleteUserById(Integer id) {
	repo.deleteById(id);
	return null;
}

@Override
public List<USER1> Sortbyname() {
	List<USER1> list=repo.findAll();
	return list.stream().sorted(Comparator.comparing(USER1::getName)).collect(Collectors.toList());
}


/////kalyan
@Override
public USER1 addCustomer(USER1 c) {
	repo.save(c);
	return c;
	}

@Override
public USER1 deleteCustomer(Integer id) {
	// TODO Auto-generated method stub
	USER1 cust = repo.getById(id);
	repo.deleteById(id);
	return cust;
	
}

@Override
public USER1 updateCustomer(Integer id, USER1 c)
{
    USER1 cust = repo.getById(id);
	cust.setName(c.getName());
	cust.setAge(c.getAge());
	cust.setEmail(c.getEmail());
	cust.setGender(c.getGender());
	cust.setMedname1(c.getMedname1());
	cust.setMedname2(c.getMedname2());
	cust.setMedname3(c.getMedname3());
	cust.setMedname4(c.getMedname4());
	cust.setMedname5(c.getMedname5());
	cust.setMed1qty(c.getMed1qty());
	cust.setMed2qty(c.getMed2qty());
	cust.setMed3qty(c.getMed3qty());
	cust.setMed4qty(c.getMed4qty());
	cust.setMed5qty(c.getMed5qty());
	repo.save(cust);
	return cust;
	
}
public void updateqty(String medname,int qty1)
{
    medicines m=mrepo.getBymedname(medname);
    m.setQuantity(m.getQuantity()-qty1);
    mrepo.save(m);
}
 public double getmanybill(int id) 
 {
		USER1 u=repo.getById(id);
		String m1=u.getMedname1();
		String m2=u.getMedname2();
		String m3=u.getMedname3();
		String m4=u.getMedname4();
		String m5=u.getMedname5();

		updateqty(m1,u.getMed1qty());
		updateqty(m2,u.getMed2qty());
		updateqty(m3,u.getMed3qty());
		updateqty(m4,u.getMed4qty());
		updateqty(m5,u.getMed5qty());
	 int d= (getbill(m1)*u.getMed1qty())+(getbill(m2)*u.getMed2qty())+(getbill(m3)*u.getMed3qty())+(getbill(m4)*u.getMed4qty())+(getbill(m5)*u.getMed5qty());
	 double dis = 0;
	 if(d>=500) {
		 dis=d-(d*0.1);
	 }
	 return dis;
	 
 }
@Override
public int getbill(String medname) {
	// TODO Auto-generated method stub

	List<medicines> l=mrepo.findAll();
	for(medicines i:l)
	{
		if(i.getMedname().equalsIgnoreCase(medname))
		{
			
			return i.getCost();
			
		}
	}
	return 0;
}

@Override
public userlogin add(userlogin u) {
	// TODO Auto-generated method stub
	urepo.save(u);
	return u;
}

@Override
public String updatepwd(String userid,userlogin u1) {
	// TODO Auto-generated method stub
	userlogin u=urepo.getById(userid);
	u.setPassword(u1.getPassword());
	urepo.save(u);
	return "Password changed Successfully";
}

}
