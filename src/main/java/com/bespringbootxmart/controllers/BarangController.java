package com.bespringbootxmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bespringbootxmart.dto.response.BarangDTORes;
import com.bespringbootxmart.services.BarangService;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllBarang() {
        try {
            return barangService.getAllBarang();
        } catch (Exception e) {
            BarangDTORes errorResponse = new BarangDTORes();
            errorResponse.setRfid("Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
