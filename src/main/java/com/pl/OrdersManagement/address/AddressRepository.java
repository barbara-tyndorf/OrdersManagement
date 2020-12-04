package com.pl.OrdersManagement.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByName (String name);
	List<Address> findByCity (String name);

}
