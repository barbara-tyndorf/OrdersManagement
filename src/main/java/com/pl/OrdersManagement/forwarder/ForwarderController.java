package com.pl.OrdersManagement.forwarder;

import javax.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Forwarder add (@Valid @RequestBody Forwarder forwarder) {
		return forwarderService.add(forwarder);
	}

	@GetMapping
	public List<Forwarder> getAll() {
		return forwarderService.getAll();
	}

	@GetMapping("/{id}")
	public Forwarder getForwarderById(@Valid @PathVariable long id) {
		return forwarderService.findById(id);
	}


}
