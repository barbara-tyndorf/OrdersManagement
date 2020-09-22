package com.pl.OrdersManagement.address;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	private final AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService){
		this.addressService = addressService;
	}

	@GetMapping
	public List<Address> getAll() {
		return addressService.getAll();
	}

	@PostMapping
	public Address add(Address address) {
		return addressService.add(address);
	}

	@GetMapping("/{id}")
	public Address getAddressById(@RequestParam long id) {
		return addressService.findById(id);
	}

	@GetMapping("/find")
	public List<Address> getAddressBy(@RequestParam(required = false) Map<String, String> params) {
		return addressService.findBy(params);
	}

}
