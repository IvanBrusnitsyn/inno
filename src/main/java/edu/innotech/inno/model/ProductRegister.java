package edu.innotech.inno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRegister {
    private Long id;
    private Product productId;
    private String type;
    private BigInteger account;
    private String currencyCode;
    private String state;
    private String accountNumber;

}
