package com.bespringbootxmart.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerServiceInterface {
    ResponseEntity<Object> getAllCustomer();

    ResponseEntity<Object> getCustomerByQrCode(String qrCode);
}
