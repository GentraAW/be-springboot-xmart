//CustomerModel.java
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
@Table(name = "customer", schema = "public")
public class CustomerModel {
    @Id
    @Column(name = "qr_code", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String qrCode;

    @Column(name = "nama")
    private String nama;

    @Column(name = "wallet")
    private Integer wallet;
}