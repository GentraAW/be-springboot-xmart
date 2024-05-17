package com.bespringbootxmart.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bespringbootxmart.dto.response.CustomerDTORes;
import com.bespringbootxmart.model.CustomerModel;
import com.bespringbootxmart.repositories.CustomerRepo;

@Service
public class CustomerService implements CustomerServiceInterface {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public ResponseEntity<Object> getAllCustomer() {
        List<CustomerModel> customerModels = customerRepo.findAll();

        List<CustomerDTORes> customerDTOs = customerModels.stream()
                .map(customer -> {
                    CustomerDTORes response = CustomerDTORes.builder().build();
                    response.setQrCode(customer.getQrCode());
                    response.setNama(customer.getNama());
                    response.setWallet(customer.getWallet());
                    return response;
                }).collect(Collectors.toList());

        return ResponseEntity.ok(customerDTOs);
    }

    @Override
    public ResponseEntity<Object> getCustomerByQrCode(String qrCode) {
        CustomerModel customerModel = customerRepo.findByQrCode(qrCode);
        if (customerModel != null) {
            CustomerDTORes customerDTORes = new CustomerDTORes();
            customerDTORes.setQrCode(customerModel.getQrCode());
            customerDTORes.setNama(customerModel.getNama());
            customerDTORes.setWallet(customerModel.getWallet());
            return ResponseEntity.ok(customerDTORes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
