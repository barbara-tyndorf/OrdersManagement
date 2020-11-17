package com.pl.OrdersManagement.forwarder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pl.OrdersManagement.enumeration.Branch;
import com.pl.OrdersManagement.forwarder.errors.ForwarderExistException;
import com.pl.OrdersManagement.forwarder.errors.NoForwarderFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForwarderService {

	private final ForwarderRepository forwarderRepository;

	@Autowired
	public ForwarderService(ForwarderRepository forwarderRepository) {
		this.forwarderRepository = forwarderRepository;
	}

	public List<Forwarder> getAll() {
		return forwarderRepository.findAll();
	}

	public Forwarder add(Forwarder forwarder) {
		forwarderRepository.findAll().stream()
				.filter((f) -> f.getEmail().equals(forwarder.getEmail()))
				.findAny()
				.ifPresent((f) -> {
					throw new ForwarderExistException();
				});
		return forwarderRepository.save(forwarder);
	}

	public Forwarder findById(String id) {
		return forwarderRepository.findById(id)
				.orElseThrow(() -> {
					throw new NoForwarderFoundException();
				});
	}

	public List<Forwarder> findBy(Map<String, String> params) {
		//TODO find by name, lastname, branch;
		List<Forwarder> foundForwarders = new ArrayList<>();
		if (params.containsKey("branch")) {
			Branch branch = Branch.valueOf(params.get("branch"));
			foundForwarders.addAll(forwarderRepository.findByBranch(branch));
		}
		if (params.containsKey("lastName")) {
			String lastName = params.get("lastName");
			foundForwarders.addAll(forwarderRepository.findByLastName(lastName));
		}
		if (params.containsKey("firstName") && params.containsKey("lastName")) {
			String firstName = params.get("firstName");
			String lastName = params.get("lastName");
			foundForwarders.addAll(forwarderRepository.findByFirstNameAndLastName(firstName, lastName));
		}
		return foundForwarders;
	}

	public String remove(String id) {
		Forwarder forwarder = findById(id);
		forwarderRepository.delete(forwarder);
		return "Forwarder removed successfully!";
	}

	public Forwarder updateForwarder(String id, Map<String, String> params) {
		Forwarder forwarder = findById(id);

		//TODO

		return forwarder;
	}

}
