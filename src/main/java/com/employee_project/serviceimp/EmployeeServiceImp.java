package com.employee_project.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.employee_project.dao.EmployeeRepo;
import com.employee_project.dto.AddressDto;
import com.employee_project.dto.EmployeeDto;
import com.employee_project.exception.EmployeeNotFoundException;
import com.employee_project.model.Address;
import com.employee_project.model.Employee;
import com.employee_project.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	private final ModelMapper mapper;
	private final EmployeeRepo employeeRepo;
	
	public EmployeeServiceImp(ModelMapper modelMapper,EmployeeRepo employeeRepo) {
		this.mapper = modelMapper;
		this.employeeRepo = employeeRepo;
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		Employee employee=mapper.map(employeeDto, Employee.class);
		if(employeeDto.getAddress() != null ) {
			Address address = mapper.map(employeeDto.getAddress(), Address.class);
			address.setEmployee(employee);
			employee.setAddress(address);
		}
		Employee savedEmployee = employeeRepo.save(employee);
		return mapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(Long empId) {
		Employee employee=employeeRepo.findById(empId).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with this id "+empId));
		return mapper.map(employee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(Long empId, EmployeeDto employeeDto) {
		Employee employee=employeeRepo.findById(empId).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with this id "+empId));
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		if(employeeDto.getAddress() != null ) {
			Address address = mapper.map(employeeDto.getAddress(), Address.class);
			address.setEmployee(employee);
			employee.setAddress(address);
		}
		Employee updatedEmployee = employeeRepo.save(employee);
		return mapper.map(updatedEmployee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Long empId) {
		Employee employee=employeeRepo.findById(empId).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with this id "+empId));
		employeeRepo.delete(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employeeList=employeeRepo.findAll();
		return employeeList.stream().map(employee -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto addAdressToEmployee(Long empId, AddressDto addressDto) {
		Employee employee=employeeRepo.findById(empId).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with this id "+empId));
		Address address=mapper.map(addressDto, Address.class);
		address.setEmployee(employee);
		employee.setAddress(address);
		Employee updatedEmployee = employeeRepo.save(employee);
		return mapper.map(updatedEmployee, EmployeeDto.class);
	}

	@Override
	public AddressDto getAddressOfEmployee(Long empId) {
		Employee employee=employeeRepo.findById(empId).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with this id "+empId));
		return mapper.map(employee.getAddress(), AddressDto.class);
	}
	
}
