package com.pl.OrdersManagement.contractor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<Contractor, Long> {

    Contractor findByName (String name);
}
