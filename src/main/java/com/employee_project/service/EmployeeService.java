package com.employee_project.service;

import java.util.List;

import com.employee_project.dto.AddressDto;
import com.employee_project.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto addEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long empId);
	EmployeeDto updateEmployee(Long empId,EmployeeDto employeeDto);
	void deleteEmployee(Long empId);
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto addAdressToEmployee(Long empId, AddressDto addressDto);
	AddressDto getAddressOfEmployee(Long empId);
	
}
