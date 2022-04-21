package com.example.demo;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public interface medicinesService {
	
		void savemed(medicines m);
		
		List<medicines>fetchMedicineList();
	    
		medicines updateMedicines(medicines m,int id) ;
		
		medicines deletemedById(int id);
		medicines findById(int id);
		medicines findBymedname(String medname);
		List<medicines> findBymedtype(String medtype);
		List<medicines> SortMedicinesByname();
		HashMap<String,String> checkStock();
		
		
		List<medicines> getall();
		HashMap<String,Integer> counttype();
		String givesubstitute(String medname);
		String checkexp(int medid) throws ParseException;
		HashMap<String,String> checkexpbyname(USER1 u) throws ParseException;
	
	
	

}
