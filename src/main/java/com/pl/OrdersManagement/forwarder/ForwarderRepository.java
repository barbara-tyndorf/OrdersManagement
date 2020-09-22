package com.pl.OrdersManagement.forwarder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ForwarderRepository extends JpaRepository<Forwarder, Long> {

	List<Forwarder> findByFullName (String fullName);
}
