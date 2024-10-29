package com.employee_project.dto;



public class EmployeeDto {
	private Long empId;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto addressDto;
    
	public EmployeeDto() {
		super();
	}

	public EmployeeDto(Long empId, String firstName, String lastName, String email, AddressDto addressDto) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.addressDto = addressDto;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressDto getAddress() {
		return addressDto;
	}

	public void setAddress(AddressDto addressDto) {
		this.addressDto = addressDto;
	}
    
}
