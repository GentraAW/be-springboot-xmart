//TransaksiDTORes.java
package com.bespringbootxmart.dto.response;

import java.util.Date;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransaksiDTORes {
    private String transaksiId;
    private String qrCode;
    private String rfid;
    private String namaBarang;
    private Integer hargaSatuan;
    private Integer jumlah;
    private Date date;
}
