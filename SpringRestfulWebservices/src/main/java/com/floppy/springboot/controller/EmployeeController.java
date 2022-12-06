package com.floppy.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.floppy.springboot.model.Employee;
import com.floppy.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// build create employee REST API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	//Build get All employee Details in REST API
	@GetMapping()
	public List<Employee> getAllemployee()
	{
		return employeeService.getAllEmp();
	}
	
	//Build Rest api to get employee By ID
	//http://localhost8080:/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") long  empid)
	{
		return new ResponseEntity<Employee>(employeeService.getEmpById(empid), HttpStatus.OK);
	}
	
	//Build Update employee using Rest API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "id") long id,
			                                              @RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmp(emp, id),HttpStatus.OK);
	}
	
	
	//Build Delete employee using Rest API
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete_Employee(@PathVariable("id") long id)
	{
		employeeService.DeleteEmp(id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
}
