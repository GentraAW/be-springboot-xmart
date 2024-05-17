//BarangRepo.java
package com.bespringbootxmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bespringbootxmart.model.BarangModel;

@Repository
public interface BarangRepo extends JpaRepository<BarangModel, String> {
    BarangModel findByRfid(String rfid);
}
