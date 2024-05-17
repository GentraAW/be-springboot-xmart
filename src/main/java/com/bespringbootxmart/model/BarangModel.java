//BarangModel.java
package com.bespringbootxmart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "barang", schema = "public")
public class BarangModel {
    @Id
    @Column(name = "rfid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String rfid;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga_satuan")
    private Integer hargaSatuan;
}