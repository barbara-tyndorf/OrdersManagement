package com.pl.OrdersManagement.address;

import com.pl.OrdersManagement.contractor.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByContractor(Contractor contractor);

    List<Address> findAllByCity(String city);

    List<Address> findAllByZip(String zip);

    List<Address> findAllByCountryCode(String countryCode);

    List<Address> findAllByStreet(String street);

    List<Address> findAllByStreetAndStreetAndZipAndCity(@NotNull String street, @NotNull String street2, @NotNull @Size(min = 2) String zip, @NotNull @Size(min = 1) String city);
}
