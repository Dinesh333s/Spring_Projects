package com.floppy.springboot.service;

import java.util.List;

import com.floppy.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmp();
	Employee getEmpById(long id);
	Employee updateEmp(Employee emp, long id);
	void DeleteEmp(long id);
}
