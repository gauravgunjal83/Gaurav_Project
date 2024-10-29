package com.employee_project.serviceimp;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.employee_project.dao.AddressRepo;
import com.employee_project.dao.EmployeeRepo;
import com.employee_project.dto.AddressDto;
import com.employee_project.exception.AddressNotFoundException;
import com.employee_project.model.Address;
import com.employee_project.model.Employee;
import com.employee_project.service.AddressService;

import jakarta.transaction.Transactional;

@Service
public class AddressServiceImp implements AddressService {
	private final AddressRepo addressRepo;
	private final ModelMapper mapper;
	private final EmployeeRepo employeeRepo;
	
	public AddressServiceImp(AddressRepo addressRepo, ModelMapper mapper, EmployeeRepo employeeRepo) {
		this.addressRepo=addressRepo;
		this.mapper=mapper;
		this.employeeRepo=employeeRepo;
	}
	@Override
	public AddressDto addAddress(AddressDto addressDto) {
		Address address=mapper.map(addressDto, Address.class);
		return mapper.map(addressRepo.save(address), AddressDto.class);
	}

	@Override
	public AddressDto getAddressById(Long id) {
		Address address=addressRepo.findById(id).orElseThrow(()-> new AddressNotFoundException("Address Not Found with this id "+id));
		return mapper.map(address, AddressDto.class);
	}

	@Override
	public AddressDto updateAddress(Long id, AddressDto addressDto) {
		Address existingAddress=addressRepo.findById(id).orElseThrow(()-> new AddressNotFoundException("Address Not Found with this id "+id));
		existingAddress.setStreet(addressDto.getStreet());
		existingAddress.setCity(addressDto.getCity());
		existingAddress.setState(addressDto.getState());
		existingAddress.setZipcode(addressDto.getZipcode());
		addressRepo.save(existingAddress);
		return mapper.map(existingAddress, AddressDto.class);
	}	
	@Transactional
	@Override
	public void deleteAddress(Long id) {
		Address existingAddress=addressRepo.findById(id).orElseThrow(()-> new AddressNotFoundException("Address Not Found with this id "+id));
		Employee employee = existingAddress.getEmployee();
		addressRepo.delete(existingAddress);
		employee.setAddress(null);
		employeeRepo.save(employee);
	}
	@Override
	public List<AddressDto> getAllAddresses() {
		List<Address> addressList=addressRepo.findAll();
		return addressList.stream().map(address -> mapper.map(address, AddressDto.class)).collect(Collectors.toList());
	}	
}
