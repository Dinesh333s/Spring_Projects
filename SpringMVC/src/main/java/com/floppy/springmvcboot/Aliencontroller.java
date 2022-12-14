package com.floppy.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.floppy.springmvcboot.model.Alien;

//@Controller
@RestController //using @ResponseBody everytime .. we can use Restcontroller one time at the topic
public class Aliencontroller {

	@Autowired
	Alienrepo repo;

	
	//getting all the data
	@GetMapping(path="aliens" , produces = {"application/xml"}) 
//	@ResponseBody
	public List<Alien> getalien()
	{
	List<Alien> aliens = repo.findAll();
//	int i = 9/0;
	System.out.println("I m get alien method");
	
		return aliens;
		
	}
	
//getting particular data
	@GetMapping("aliens/{aid}")
//	@ResponseBody
	public Alien selectOne(@PathVariable int aid)
	{
		    Alien aliens= repo.findById(aid).orElse(new Alien(0,""));
		return aliens;
	}
	
//Add aliens
	@PostMapping(path="aliens",consumes = {"application/xml"})
	public Alien addAlien(@RequestBody Alien aliens)  // @Requestbody convert data into java object
	{
		Alien alien =  repo.save(aliens);
		return alien;
	}
	
	
}
