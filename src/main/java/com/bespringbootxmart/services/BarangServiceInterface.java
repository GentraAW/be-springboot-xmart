//BarangServiceInterface.java
package com.bespringbootxmart.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BarangServiceInterface {
    ResponseEntity<Object> getAllBarang();
}