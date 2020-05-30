package com.pl.OrdersManagement.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

}
