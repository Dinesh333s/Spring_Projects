package com.floppy.Hello.world;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	//return bean
	@GetMapping("/student")
	public Student getStudent()
	{
		return new Student("Dinesh","S");
	}
	
	
	//return List of students
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		List<Student> students = new ArrayList<>();
		students.add(new Student("naruto", "Uzumaki"));
		students.add(new Student("Hinata", "hyuga"));
		students.add(new Student("ino", "yamanaka"));
		students.add(new Student("shino", "Aburame"));
		students.add(new Student("Itachi", "Uchiha"));
		
		return students;
	}
	
	//PathVariable http:localhost:8080/student/firstname/lastname	
	@GetMapping("/student/{firstname}/{lastname}")
	public Student pathVariable(@PathVariable("firstname") String first, @PathVariable("lastname") String last)
			{
				return new Student(first, last);
			}
	
	
	//Requestparam (Queryparam) http:localhost8080/student?firstName=dinesh&lastname=s
	@GetMapping("/student/queryparam")
	public Student studentQueryParam(@RequestParam(name="firstname") String first,
			@RequestParam(name="lastname") String last)
	{
		return new Student(first,last);
	}
	
	
	
	
}
