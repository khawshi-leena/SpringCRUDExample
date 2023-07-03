package com.example.SpringDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDemo.model.Employee;
import com.example.SpringDemo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PostMapping("/addEmployees")
	public List<Employee> addEmployee(@RequestBody List<Employee> employees) {
		return employeeService.saveEmployees(employees);
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	 @PutMapping("/update")
	 public Employee updateProduct(@RequestBody Employee employee) {
	       return employeeService.updateEmployee(employee);
	 }

	 @DeleteMapping("/delete/{id}")
	 public String deleteProduct(@PathVariable int id) {
	      return employeeService.deleteEmployeeById(id);
	 }
}
