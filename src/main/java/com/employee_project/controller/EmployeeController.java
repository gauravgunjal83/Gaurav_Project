package com.employee_project.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.employee_project.dto.AddressDto;
import com.employee_project.dto.EmployeeDto;
import com.employee_project.service.EmployeeService;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;	
	}
	@GetMapping("/displaycheck")
    public String displayCheck() {
    	return "Working properly";
    }
	@PostMapping("/addEmployee")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto createdEmployee = employeeService.addEmployee(employeeDto);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	@GetMapping("/getEmployeeById/{empId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long empId) {
		EmployeeDto employeeDto=employeeService.getEmployeeById(empId);
		return new ResponseEntity<>(employeeDto,HttpStatus.OK );
		
	}
	@PutMapping("/updateEmployee/{empId}")
	public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long empId,@RequestBody EmployeeDto employeeDto) {
		EmployeeDto employeeDto2= employeeService.updateEmployee(empId, employeeDto);
		return new ResponseEntity<>(employeeDto2, HttpStatus.OK);
	}
	@DeleteMapping("/deleteEmployee/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long empId) {
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<>("Employee Deleted Successfully", HttpStatus.OK);
	}
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		List<EmployeeDto> empList=employeeService.getAllEmployees();
		return new ResponseEntity<>(empList, HttpStatus.OK);	
	}
	@PostMapping("/addAddressOfEmployeeByEmpId/{empId}")
	public ResponseEntity<EmployeeDto> addAddressOfEmployee(@PathVariable Long empId,@RequestBody AddressDto addressDto){
		EmployeeDto employeeDto=employeeService.addAdressToEmployee(empId, addressDto);
		return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
	}
	@GetMapping("/getAddressOfEmployeeByEmpId/{empId}")
	public ResponseEntity<AddressDto>  getAddressOfEmployee(@PathVariable Long empId) {
		AddressDto addressDto=employeeService.getAddressOfEmployee(empId);
		return new ResponseEntity<>(addressDto, HttpStatus.OK);
	}
}
