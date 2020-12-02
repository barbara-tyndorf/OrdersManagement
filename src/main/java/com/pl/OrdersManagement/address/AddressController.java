package com.pl.OrdersManagement.address;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	private final AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
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

	@GetMapping("/id/{id}")
	public Address getAddressById(@PathVariable Long id) {
		return addressService.findById(id);
	}

	@GetMapping("/name/{name}")
	public List<Address> getAddressBy(@PathVariable Map<String, String> params) {
		return addressService.findBy(params);
	}

	@PutMapping
	public Address update(@RequestParam Long id, @Valid @RequestParam Map<String, String> params) {
		return addressService.updateAddress(id, params);
	}

	@DeleteMapping("/{id}")
	public String deleteAddress(@PathVariable Long id) {
		return addressService.remove(id);
	}

}
