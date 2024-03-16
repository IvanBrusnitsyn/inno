package edu.innotech.inno.web.model;

import edu.innotech.inno.model.Product;
import lombok.Data;

import java.math.BigInteger;

@Data
public class UpsertProductRegisterRequest {
    private Long productId;
    private String type;
    private BigInteger account;
    private String currencyCode;
    private String state;
    private String accountNumber;
}
