//BarangDTORes.java
package com.bespringbootxmart.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BarangDTORes {
    private String rfid;
    private String namaBarang;
    private Integer hargaSatuan;
}
