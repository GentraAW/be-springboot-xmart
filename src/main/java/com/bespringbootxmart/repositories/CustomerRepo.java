//CustomerRepo.java
package com.bespringbootxmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bespringbootxmart.model.CustomerModel;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, String> {
    CustomerModel findByQrCode(String qrCode);
}