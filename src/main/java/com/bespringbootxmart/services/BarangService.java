//BarangService.java
package com.bespringbootxmart.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bespringbootxmart.dto.response.BarangDTORes;
import com.bespringbootxmart.model.BarangModel;
import com.bespringbootxmart.repositories.BarangRepo;

@Service
public class BarangService implements BarangServiceInterface {
    @Autowired
    private BarangRepo barangRepo;

    @Override
    public ResponseEntity<Object> getAllBarang() {
        List<BarangModel> barangModels = barangRepo.findAll();

        List<BarangDTORes> barangDTOs = barangModels.stream()
                .map(barang -> {
                    BarangDTORes response = BarangDTORes.builder().build();
                    response.setRfid(barang.getRfid());
                    response.setNamaBarang(barang.getNamaBarang());
                    response.setHargaSatuan(barang.getHargaSatuan());
                    return response;
                }).collect(Collectors.toList());

        return ResponseEntity.ok(barangDTOs);
    }

}
