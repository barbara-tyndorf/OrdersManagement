package com.pl.OrdersManagement.address;

import com.pl.OrdersManagement.contractor.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findAllByContractor(Contractor contractor);

	List<Address> findAllByCity(String city);

	List<Address> findAllByZip(String zip);

	List<Address> findAllByCountryCode(String countryCode);

	List<Address> findAllByStreet(String street);

	Address findByCountryCodeAndCityAndZipAndStreetAndNumber(String countryCode,
			String City, String zip, String street, int number);
}
