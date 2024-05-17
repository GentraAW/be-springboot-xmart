//CustomerDTORes.java
package com.bespringbootxmart.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTORes {
    private String qrCode;
    private String nama;
    private Integer wallet;
}
