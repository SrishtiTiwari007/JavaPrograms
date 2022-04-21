package com.example.demo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface medicinesRepository extends JpaRepository<medicines,Integer>{

	medicines getBymedname(String medname);

	List<medicines> getBymedtype(String medtype);
	@Query(value="select quantity from medicines")
	public ArrayList<Integer> findquantity();
    @Query(value="select medname from medicines")
	ArrayList<String> findmedname();
    @Query(value="select cost from medicines")
	List<Integer> findcost();
    @Query(value="select expdate from medicines")
	List<Date> finddate();
}
