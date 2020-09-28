package com.pl.OrdersManagement.contractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pl.OrdersManagement.address.AddressService;
import com.pl.OrdersManagement.address.errors.AddressExistException;
import com.pl.OrdersManagement.contractor.errors.NoContractorFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;
    private final AddressService addressService;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository, AddressService addressService) {
        this.contractorRepository = contractorRepository;
        this.addressService = addressService;
    }

    public Contractor add(Contractor contractor) {
        contractorRepository.findAll().stream()
                .filter((a) -> a.getVatId().equals(contractor.getVatId()))
                .findAny()
                .ifPresent((a) -> {
                    throw new AddressExistException();
                });
        return contractorRepository.save(contractor);
    }

    public List<Contractor> getAll() {
        return contractorRepository.findAll();
    }

    public Contractor findById(long id) {
        return contractorRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NoContractorFoundException();
                });
    }

    public List<Contractor> findBy(Map<String, String> params) {
        List<Contractor> foundContractors = new ArrayList<>();

        if (params.containsKey("id")) {
            Long id = Long.parseLong(params.get("id"));
            contractorRepository.findById(id)
                    .ifPresent(foundContractors::add);
        }
        if (params.containsKey("name")) {
            String name = params.get("name");
            foundContractors.addAll(contractorRepository.findByName(name));
        }
        if (params.containsKey("vatId")) {
            String vatId = params.get("vatId");
            foundContractors.add(contractorRepository.findByVatId(vatId));
        }
        return foundContractors;
    }

    public Contractor updateContractor(long id, Map<String, String> params) {
        Contractor contractor = findById(id);

        if (params.containsKey("name")) {
            String name = params.get("name");
            contractor.setName(name);
        }
        //TODO update address without duplication - use addressService
//        if (params.containsKey("companyAddress")) {
//            Address companyAddress = addressService.updateAddress(params.get("companyAddress"));
//        }

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

}
