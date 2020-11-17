package com.pl.OrdersManagement.contractor;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contractor")
public class ContractorController {

	private final ContractorService contractorService;

	@Autowired
	public ContractorController(ContractorService contractorService) {
		this.contractorService = contractorService;
	}

	@GetMapping
	public List<Contractor> getAll() {
		return contractorService.getAll();
	}

	@PostMapping
	public Contractor add(@Valid @RequestBody Contractor contractor) {
		return contractorService.add(contractor);
	}

	@GetMapping("/{id}")
	public Contractor findById(@PathVariable String id) {
		return contractorService.findById(id);
	}

	@GetMapping("find")
	public List<Contractor> findBy(@RequestParam Map<String, String> params) {
		return contractorService.findBy(params);
	}

	@PutMapping
	public Contractor update(@RequestParam String id, @Valid @RequestParam Map<String, String> params) {
		return contractorService.updateContractor(id, params);
	}

	@DeleteMapping("/{id}")
	public String deleteContractor(@PathVariable String id){
		return contractorService.remove(id);
	}
}
