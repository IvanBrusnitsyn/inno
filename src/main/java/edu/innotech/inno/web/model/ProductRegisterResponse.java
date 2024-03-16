package edu.innotech.inno.web.model;

import edu.innotech.inno.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRegisterResponse {
    private Long id;
//    private Product productId; // - в уроке этого не было
    private String type;
    private BigInteger account;
    private String currencyCode;
    private String state;
    private String accountNumber;
}
