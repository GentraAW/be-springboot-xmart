//TransaksiModel.java
package com.bespringbootxmart.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaksi", schema = "public")
public class TransaksiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaksi_id", nullable = false, unique = true)
    private String transaksiId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qr_code", referencedColumnName = "qr_code")
    private CustomerModel customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rfid", referencedColumnName = "rfid")
    private BarangModel barang;

    @JoinColumn(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga_satuan")
    private Integer hargaSatuan;

    @Column(name = "jumlah")
    private Integer jumlah;

    @Column(name = "date")
    private Date date;
}