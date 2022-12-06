package com.floppy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floppy.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
