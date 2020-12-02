package com.pl.OrdersManagement.forwarder;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forwarders")
public class ForwarderController {

	private final ForwarderService forwarderService;

	@Autowired
	public ForwarderController(ForwarderService forwarderService) {
		this.forwarderService = forwarderService;
	}

	@PostMapping
	public Forwarder add(@Valid @RequestBody Forwarder forwarder) {
		return forwarderService.add(forwarder);
	}

	@GetMapping
	public List<Forwarder> getAll() {
		return forwarderService.getAll();
	}

	@GetMapping("/{id}")
	public Forwarder getForwarderById(@PathVariable String id) {
		return forwarderService.findById(id);
	}

	@GetMapping("/findBy")
	public List<Forwarder> getForwarderBy(@RequestBody Map<String, String> params) {
		return forwarderService.findBy(params);
	}

	@DeleteMapping("/{id}")
	public String deleteForwarder(@PathVariable String id) {
		return forwarderService.remove(id);
	}


	@PutMapping
	public Forwarder update(@RequestBody String id, Map<String, String> params) {
		return forwarderService.updateForwarder(id, params);
	}

}
