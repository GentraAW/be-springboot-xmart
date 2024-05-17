package com.bespringbootxmart.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bespringbootxmart.dto.response.TransaksiDTORes;
import com.bespringbootxmart.services.TransaksiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @GetMapping("get-all")
    public ResponseEntity<Object> getAllTransaksi() {
        try {
            return transaksiService.getAllTransaksi();
        } catch (Exception e) {
            TransaksiDTORes errorResponse = new TransaksiDTORes();
            errorResponse.setTransaksiId("Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
