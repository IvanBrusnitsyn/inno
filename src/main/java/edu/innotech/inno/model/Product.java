package edu.innotech.inno.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "tpp_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigInteger productCodeId;
    private BigInteger clientId;
    private String type;
//    @Column(name = "number")
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

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ProductRegister> productRegisters = new ArrayList<>();

//    public void addAgreement(Agreement agreement) {
//        agreements.add(agreement);
//    }
//
//    public void removeAgreement(Long agreementId) {
//        agreements = agreements.stream().filter(a -> !a.getId().equals(agreementId)).collect(Collectors.toList());
//    }

    public void addProductRegister(ProductRegister productRegister) {
        if (productRegisters == null) productRegisters = new ArrayList<>();
        productRegisters.add(productRegister);
    }

    public void removeProductRegister(Long productRegisterId) {
        productRegisters = productRegisters.stream().filter(a -> !a.getId().equals(productRegisterId)).collect(Collectors.toList());
    }

    public List<ProductRegister> getProductRegisters() {
        if (productRegisters == null) productRegisters = new ArrayList<>();
        return productRegisters;
    }
}
