package com.pl.OrdersManagement.contractor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<Contractor, Long> {

    List<Contractor> findByName (String name);

    Contractor findByVatId (String vatId);
}
