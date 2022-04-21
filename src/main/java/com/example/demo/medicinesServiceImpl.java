
package com.example.demo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service
public class medicinesServiceImpl implements medicinesService {
		@Autowired
		medicinesRepository repo;
		@Autowired
		UserRepository urepo;
		medicines me=new medicines();
		@Override
		public void savemed(medicines m) {
			repo.save(m);
		}
		@Override
		public List<medicines>fetchMedicineList(){
			List<medicines> list= repo.findAll();
			return list;
		}
		@Override
		public medicines updateMedicines(medicines m ,int id) {
			medicines me=repo.getById(id);
			me.setMedname(m.getMedname());
			me.setMedtype(m.getMedtype());
			me.setSubstitute(m.getSubstitute());
			me.setExpdate(m.getExpdate());
			me.setCost(m.getCost());
			me.setQuantity(m.getQuantity());
		    repo.save(me);
		    return me;
		
		}
		@Override
		public medicines deletemedById(int id) {
			repo.deleteById(id);
			return null;
		}
		@Override
		public medicines findById(int id) {
			medicines m= repo.getById(id);
			return m;
		}
		@Override
		public medicines findBymedname(String medname) {
			medicines mn= repo.getBymedname(medname);
			return mn;
		}
		
		@Override
		public List<medicines> findBymedtype(String medtype) {
			List<medicines> mt= repo.getBymedtype(medtype);
			return mt;
		}
		
		@Override
		public List<medicines> SortMedicinesByname(){
			List<medicines> list=repo.findAll();
			return list.stream().sorted(Comparator.comparing(medicines::getMedname)).collect(Collectors.toList());
			
		}
		
		@Override
		public HashMap<String,String> checkStock() {
			ArrayList<Integer> l=repo.findquantity();
			ArrayList<String> list=repo.findmedname();
			HashMap<String,String> map=new HashMap<>();
			for (int i=0;i<l.size();i++) {
				if(l.get(i)<=1) {
					map.put(list.get(i), "Out of stock");
				}
				else {
					map.put(list.get(i), "In Stock");
				}
				
			}
			return map;
		}
		
		@Override
		public List<medicines> getall() {
			// TODO Auto-generated method stub
			List<medicines> l=repo.findAll();
			return l;
		}
		@Override
		public HashMap<String, Integer> counttype() {
			// TODO Auto-generated method stub
			List<medicines> l=repo.findAll();
			HashMap<String,Integer> map=new HashMap<String,Integer>();
			for(medicines i :l)
			{
				if(map.containsKey(i.getMedtype()))
				{
					map.put(i.getMedtype(),map.get(i.getMedtype())+1);			
				}
				else
					map.put(i.getMedtype(), 1);
			}
			return map;
		}
		@Override
		public String givesubstitute(String medname) {
			// TODO Auto-generated method stub
			List<medicines> l=repo.findAll();
			HashMap<String,String> map=new HashMap<String,String>();
			for(medicines i:l)
			{
				map.put(i.getMedname(), i.getSubstitute());
			}
			if(map.containsKey(medname))
				return map.get(medname);
			else
			return null;
		}
		@Override
		public String checkexp(int medid) throws ParseException {
			// TODO Auto-generated method stub
			List<medicines> l=repo.findAll();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date date1 = sdf.parse(sdf.format(new Date()));
			for(medicines i:l)
			{
				if(i.getMedid()==medid)
				{
					if(i.getExpdate().before(date1))
						return "Medicine Expired";
					else
						return "Medicine not expired";
				}
			}
			
			return "Medicine not present in the id";
		}
		@Override
		public HashMap<String,String> checkexpbyname(USER1 u) throws ParseException {
			// TODO Auto-generated method stub
			String med1=u.getMedname1();
			String med2=u.getMedname2();
			String med3=u.getMedname3();
			String med4=u.getMedname4();
			String med5=u.getMedname5();
			List<medicines> m1= repo.findAll();
			HashMap<String,String> map=new HashMap<>();
			for(medicines i:m1)
			{
				if(i.getMedname().equalsIgnoreCase(med1))
				{
					map.put(i.getMedname(),checkexp(i.getMedid()));
				}
				if(i.getMedname().equalsIgnoreCase(med2))
				{
					map.put(i.getMedname(),checkexp(i.getMedid()));
				}
				if(i.getMedname().equalsIgnoreCase(med3))
				{
					map.put(i.getMedname(),checkexp(i.getMedid()));
				}
				if(i.getMedname().equalsIgnoreCase(med4))
				{
					map.put(i.getMedname(),checkexp(i.getMedid()));
				}
				if(i.getMedname().equalsIgnoreCase(med5))
				{
					map.put(i.getMedname(),checkexp(i.getMedid()));
				}
			}
			return map;
		}
		}
