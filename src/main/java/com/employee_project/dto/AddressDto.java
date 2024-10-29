package com.employee_project.dto;

public class AddressDto {
	private Long id;
	private String street;
    private String city;
    private String state;
	private Long zipcode;
	

	public AddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDto(Long id, String street, String city, String state, Long zipcode) {
		super();
		this.id=id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getZipcode() {
		return zipcode;
	}

	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}	
	
}
