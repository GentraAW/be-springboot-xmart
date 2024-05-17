package com.bespringbootxmart.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bespringbootxmart.dto.response.TransaksiDTORes;
import com.bespringbootxmart.model.TransaksiModel;
import com.bespringbootxmart.repositories.TransaksiRepo;

@Service
public class TransaksiService implements TransaksiServiceInterface {

    @Autowired
    private TransaksiRepo transaksiRepo;

    @Override
    public ResponseEntity<Object> getAllTransaksi() {
        List<TransaksiModel> transaksiModels = transaksiRepo.findAll();

        List<TransaksiDTORes> transaksiDTOs = transaksiModels.stream()
                .map(transaksi -> {
                    TransaksiDTORes response = TransaksiDTORes.builder().build();
                    response.setTransaksiId(transaksi.getTransaksiId());
                    response.setQrCode(transaksi.getCustomer().getQrCode());
                    response.setRfid(transaksi.getBarang().getRfid());
                    response.setNamaBarang(transaksi.getNamaBarang());
                    response.setHargaSatuan(transaksi.getBarang().getHargaSatuan());
                    response.setJumlah(transaksi.getJumlah());
                    response.setDate(transaksi.getDate());
                    return response;
                }).collect(Collectors.toList());

        return ResponseEntity.ok(transaksiDTOs);
    }

}
