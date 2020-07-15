package com.pl.OrdersManagement.forwarder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ForwarderRepository extends JpaRepository<Forwarder, Long> {

	Forwarder findByFullName (String fullName);
}
