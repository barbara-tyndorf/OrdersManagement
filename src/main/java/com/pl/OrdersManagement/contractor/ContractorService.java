package com.pl.OrdersManagement.contractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pl.OrdersManagement.contractor.errors.ContractorExistException;
import com.pl.OrdersManagement.contractor.errors.NoContractorFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    public Contractor add(Contractor contractor) {
        contractorRepository.findAll().stream()
                .filter((c) -> c.getVatId().equals(contractor.getVatId()))
                .findAny()
                .ifPresent((c) -> {
                    throw new ContractorExistException();
                });
        return contractorRepository.save(contractor);
    }

    public List<Contractor> getAll() {
        return contractorRepository.findAll();
    }

    public Contractor findById(String id) {
        return contractorRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NoContractorFoundException();
                });
    }

    public List<Contractor> findBy(Map<String, String> params) {
        List<Contractor> foundContractors = new ArrayList<>();

        if (params.containsKey("name")) {
            String name = params.get("name");
            foundContractors.add(contractorRepository.findByName(name));
        }
        if (params.containsKey("vatId")) {
            String vatId = params.get("vatId");
            foundContractors.add(contractorRepository.findByVatId(vatId));
        }
        return foundContractors;
    }

    public Contractor updateContractor(String id, Map<String, String> params) {
        Contractor contractor = findById(id);

        if (params.containsKey("name")) {
            String name = params.get("name");
            contractor.setName(name);
        }
        //TODO update address

        if (params.containsKey("vatId")) {
            String vatId = params.get("vatId");
            contractor.setVatId(vatId);
        }
        if (params.containsKey("contactPerson")) {
            String contactPerson = params.get("contactPerson");
            contractor.setContactPerson(contactPerson);
        }
        if (params.containsKey("phoneNumber")) {
            String phoneNumber = params.get("phoneNumber");
            contractor.setPhoneNumber(phoneNumber);
        }
        return contractorRepository.save(contractor);
    }

    public String remove(String id) {
        Contractor contractor = findById(id);
        contractorRepository.delete(contractor);
        return "Contractor removed successfully!";
    }
}
