package com.floppy.springmvcboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.floppy.springmvcboot.model.Alien;

//import antlr.collections.List;
import java.util.List;

public interface Alienrepo extends JpaRepository<Alien, Integer>{


//	List<Alien> findByAname(String aname);  //Query DSL

//	List<Alien> findByAnameOrderByAname(String aname);

//	List<Alien> findByAnameOrderByAidDesc(String aname);

	@Query("from Alien where aname = :name")
	List<Alien> find(@Param(value = "name") String aname);

	

}
