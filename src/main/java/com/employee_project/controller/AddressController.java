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
import com.employee_project.service.AddressService;


@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	private final  AddressService addressService;
	
	public AddressController(AddressService addressService) {
		this.addressService=addressService;
	}
	
	@PostMapping("/addAddressOnly")
	public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto) {
		 AddressDto addressDto2 = addressService.addAddress(addressDto);
		 return new ResponseEntity<>(addressDto2, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAddressById/{id}")
	public ResponseEntity<AddressDto> getAddressById(@PathVariable Long  id) {
		AddressDto addressDto=addressService.getAddressById(id);
		return new ResponseEntity<>(addressDto, HttpStatus.OK);
	}

	@PutMapping("/updateAddress/{id}")
	public ResponseEntity<AddressDto> updateAddress(@PathVariable Long id,@RequestBody AddressDto addressDto) {
		AddressDto updateAddressDto=addressService.updateAddress(id, addressDto);
		return new ResponseEntity<>(updateAddressDto,HttpStatus.OK);
	}

	@DeleteMapping("/deleteAddress/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable long id) {
		addressService.deleteAddress(id);
		return new ResponseEntity<>("Address deleted sucessfully", HttpStatus.OK);
	}
	
	@GetMapping("/getAllAddress")
	public ResponseEntity<List<AddressDto>> getMethodName() {
		List<AddressDto> addressList=addressService.getAllAddresses();
		return new ResponseEntity<>(addressList,HttpStatus.OK);
	}
	
}
