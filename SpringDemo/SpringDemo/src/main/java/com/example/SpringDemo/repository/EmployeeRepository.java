package com.example.SpringDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringDemo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
   public Employee findByFirstName(String firstName);
}
