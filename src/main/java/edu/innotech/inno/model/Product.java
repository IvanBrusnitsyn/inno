package edu.innotech.inno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private BigInteger productCodeId;
    private BigInteger clientId;
    private String type;
    private String number;
    private BigInteger priority;
    private Instant dateOfConclusion;
    private Instant startDateTime;
    private Instant endDateTime;
    private BigInteger days;
    private BigDecimal penaltyRate;
    private BigDecimal nso;
    private BigDecimal threshOldAmount;
    private String requisiteType;
    private String interestRateType;
    private BigDecimal taxRate;
    private String reasoneClose;
    private String state;
//    private List<Agreement> agreements = new ArrayList<>();
    private List<ProductRegister> productRegisters = new ArrayList<>();

//    public void addAgreement(Agreement agreement) {
//        agreements.add(agreement);
//    }
//
//    public void removeAgreement(Long agreementId) {
//        agreements = agreements.stream().filter(a -> !a.getId().equals(agreementId)).collect(Collectors.toList());
//    }

    public void addProductRegister(ProductRegister productRegister) {
        productRegisters.add(productRegister);
    }

    public void removeProductRegister(Long productRegisterId) {
        productRegisters = productRegisters.stream().filter(a -> !a.getId().equals(productRegisterId)).collect(Collectors.toList());
    }
}
