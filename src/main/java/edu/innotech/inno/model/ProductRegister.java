package edu.innotech.inno.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ProductRegister {
    private Long id;
    private Product productId;
    private String type;
    private BigInteger account;
    private String currencyCode;
    private String state;
    private String accountNumber;

}
