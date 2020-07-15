package com.pl.OrdersManagement.address;

import com.pl.OrdersManagement.address.errors.AddressExistException;
import com.pl.OrdersManagement.contractor.Contractor;
import com.pl.OrdersManagement.contractor.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final ContractorRepository contractorRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, ContractorRepository contractorRepository) {
        this.addressRepository = addressRepository;
        this.contractorRepository = contractorRepository;
    }

    public Address add (Address address) {
        addressRepository.findAll().stream()
                .filter((a) -> a.getCountryCode().equals(address.getCountryCode()))
                .filter((a) -> a.getCity().equals(address.getCity()))
                .filter((a) -> a.getZip().equals(address.getZip()))
                .filter((a) -> a.getStreet().equals(address.getStreet()))
                .filter((a) -> a.getNumber() == address.getNumber())
                .findAny()
                .ifPresent((a) -> {
                    throw new AddressExistException();
                });
        return addressRepository.save(address);
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public List<Address> findBy (Map<String, String> params) {
        List<Address> foundAddresses = new ArrayList<>();

        if (params.containsKey("id")) {
            Long id = Long.parseLong(params.get("id"));
            addressRepository.findById(id)
                    .ifPresent(foundAddresses::add);
        }
        if (params.containsKey("contractorName")) {
            String contractorName = params.get("contractorName");
            Contractor contractor = contractorRepository.findByName(contractorName);
            foundAddresses.addAll(addressRepository.findAllByContractor(contractor));
        }
        if (params.containsKey("city")) {
            String city = params.get("city");
            foundAddresses.addAll(addressRepository.findAllByCity(city));
        }
        if (params.containsKey("countryCode")) {
            String countryCode = params.get("countryCode");
            foundAddresses.addAll(addressRepository.findAllByCountryCode(countryCode));
        }
        if (params.containsKey("zip")) {
            String zip = params.get("zip");
            foundAddresses.addAll(addressRepository.findAllByZip(zip));
        }
        if (params.containsKey("street")) {
            String street = params.get("street");
            foundAddresses.addAll(addressRepository.findAllByStreet(street));
        }
        return foundAddresses;
    }
}
