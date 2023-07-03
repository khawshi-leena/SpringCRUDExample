package com.example.SpringDemo.service;


import com.example.SpringDemo.model.Employee;
import com.example.SpringDemo.repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public List<Employee> saveEmployees(List<Employee> emps) {
		return employeeRepository.saveAll(emps);
	}
	
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public Employee getEmployeeByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	public String deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return "Employee removed with Id " + id;
	}
	
	public Employee updateEmployee(Employee e) {
		Employee existingEmp = employeeRepository.findById(e.getId()).orElse(null);
		existingEmp.setId(e.getId());
		existingEmp.setFirstName(e.getFirstName());
		existingEmp.setLastName(e.getLastName());
		existingEmp.setSalary(e.getSalary());
		return employeeRepository.save(existingEmp);
	}
}
