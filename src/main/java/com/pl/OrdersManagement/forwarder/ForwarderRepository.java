package com.pl.OrdersManagement.forwarder;

import java.util.List;

import com.pl.OrdersManagement.enumeration.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForwarderRepository extends JpaRepository<Forwarder, String> {

	List<Forwarder> findByFirstNameAndLastName(String firstName, String lastName);

	List<Forwarder> findByLastName(String lastName);

	List<Forwarder> findByBranch(Branch branch);

}
