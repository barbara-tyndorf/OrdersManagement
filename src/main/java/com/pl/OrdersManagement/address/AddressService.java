package com.pl.OrdersManagement.address;

import com.pl.OrdersManagement.address.errors.AddressExistException;
import com.pl.OrdersManagement.address.errors.NoAddressFoundException;

import com.pl.OrdersManagement.enumeration.Branch;
import com.pl.OrdersManagement.forwarder.Forwarder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address add(Address address) {
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

    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NoAddressFoundException();
                });
    }

    public List<Address> findBy(Map<String, String> params) {

        List<Address> foundAddresses = new ArrayList<>();
        if (params.containsKey("name")) {
            String name = params.get("name");
            foundAddresses.addAll(addressRepository.findByName(name));
        }
        if (params.containsKey("city")) {
            String city = params.get("city");
            foundAddresses.addAll(addressRepository.findByCity(city));
        }
        return foundAddresses;
    }

    public Address updateAddress(Long id, Map<String, String> params) {
        Address address = findById(id);

        if (params.containsKey("name")) {
            String name = params.get("name");
            address.setName(name);
        }
        if (params.containsKey("street")) {
            String street = params.get("street");
            address.setStreet(street);
        }
        if (params.containsKey("number")) {
            int number = Integer.parseInt(params.get("number"));
            address.setNumber(number);
        }
        if (params.containsKey("zip")) {
            String zip = params.get("zip");
            address.setZip(zip);
        }
        if (params.containsKey("city")) {
            String city = params.get("city");
            address.setCity(city);
        }
        if (params.containsKey("countryCode")) {
            String countryCode = params.get("countryCode");
            address.setCountryCode(countryCode);
        }
        return addressRepository.save(address);
    }

    public String remove(Long id) {
        Address address = findById(id);
        addressRepository.delete(address);
        return "Address removed successfully!";
    }
}
