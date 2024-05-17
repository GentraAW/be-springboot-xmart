package com.bespringbootxmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bespringbootxmart.dto.request.CustomerDTOReq;
import com.bespringbootxmart.dto.response.CustomerDTORes;
import com.bespringbootxmart.services.CustomerService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("get-all")
    public ResponseEntity<Object> getAllCustomer() {
        try {
            return customerService.getAllCustomer();
        } catch (Exception e) {
            CustomerDTORes errorResponse = new CustomerDTORes();
            errorResponse.setQrCode("Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/{qrCode}")
    public ResponseEntity<Object> getCustomerQrCode(@PathVariable String qrCode) {
        CustomerDTOReq request = new CustomerDTOReq();
        request.setQrCode(qrCode);
        ResponseEntity<Object> response = customerService.getCustomerByQrCode(qrCode);
        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Customer dengan QRCODE " + qrCode + " tidak ditemukan");
        } else {
            return response;
        }
    }
}
