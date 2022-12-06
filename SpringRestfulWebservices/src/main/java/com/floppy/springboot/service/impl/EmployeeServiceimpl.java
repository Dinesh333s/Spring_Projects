package com.floppy.springboot.service.impl;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.floppy.springboot.exception.ResourceNotFoundException;
import com.floppy.springboot.model.Employee;
import com.floppy.springboot.repository.EmployeeRepository;
import com.floppy.springboot.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmp() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmpById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
//		
		//LAMBA EXPRESSION 
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
	}

	@Override
	public Employee updateEmp(Employee emp, long id) {
		Employee exsisting_Emp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		exsisting_Emp.setFirstName(emp.getFirstName());
		exsisting_Emp.setLastName(emp.getLastName());
		exsisting_Emp.setEmail(emp.getEmail());
		
	//save the changes 
		employeeRepository.save(exsisting_Emp);
		return exsisting_Emp;
	}

	@Override
	public void DeleteEmp(long id) {
         employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));		
         
         employeeRepository.deleteById(id);
	}
}
