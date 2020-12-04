package com.pl.OrdersManagement.contractor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<Contractor, String> {

    Contractor findByName (String name);

    Contractor findByVatId (String vatId);
}
