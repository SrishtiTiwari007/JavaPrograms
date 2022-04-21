package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<USER1,Integer> {
	@Query(value="select name from USER1")
	public List<String> findname();
	@Query(value="select age from USER1")
	public List<Integer> findage();
	
	
}