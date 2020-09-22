package com.pl.OrdersManagement.forwarder;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForwarderService {

	private final ForwarderRepository forwarderRepository;

	@Autowired
	public ForwarderService (ForwarderRepository forwarderRepository) {
		this.forwarderRepository = forwarderRepository;
	}

	public List<Forwarder> getAll() {
		return forwarderRepository.findAll();
	}

	public Forwarder add(Forwarder forwarder) {
		return forwarderRepository.save(forwarder);
	}

	public Forwarder findById(long id) {
		return forwarderRepository.findById(id)
				.orElseThrow(() -> {
					//TODO NoForwarderFoundException
					throw new NoSuchElementException();
				});
	}

	public List<Forwarder> findByFullName (String fullName) {
		//TODO find by not full name (fullName.contains provided String);
		return forwarderRepository.findByFullName(fullName);
	}

	public String remove(long id) {
		Forwarder forwarder = findById(id);
		forwarderRepository.delete(forwarder);
		return "Forwarder removed successfully!";
	}

	public Forwarder updateForwarder(long id, Map<String, String> params) {
		Forwarder forwarder = findById(id);

		if (params.containsKey("fullName")) {
			String fullName = params.get("fullName");
			forwarder.setFullName(fullName);
		}

		return forwarder;
	}

}
