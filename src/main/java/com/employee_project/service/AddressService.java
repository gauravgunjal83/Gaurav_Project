package com.employee_project.service;


import java.util.List;

import com.employee_project.dto.AddressDto;

public interface AddressService {
	public AddressDto addAddress(AddressDto addressdto);
	public AddressDto getAddressById(Long id);
	public AddressDto updateAddress(Long id,AddressDto addressDto);
	public void deleteAddress(Long id);
	public List<AddressDto> getAllAddresses();
}
