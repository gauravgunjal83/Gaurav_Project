package com.employee_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_project.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
