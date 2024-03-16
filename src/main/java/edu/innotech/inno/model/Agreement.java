package edu.innotech.inno.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

@Data
public class Agreement {
    private Long id;
    private Product productId; // BigInteger productId; or Long?
    private String generalAgreementId;
    private String supplementaryAgreementId;
    private String arrangementType;
    private BigInteger shedulerJobId;
    private String number;
    private Instant openingDate;
    private Instant closingDate;
    private Instant cancelDate;
    private BigInteger validityDuration;
    private String cancellationReason;
    private String status;
    private Instant interestCalculationDate;
    private BigDecimal interestRate;
    private BigDecimal coefficient;
    private String coefficientAction;
    private BigDecimal minimumInterestRate;
    private BigDecimal minimumInterestRateCoefficient;
    private String minimumInterestRateCoefficientAction;


}
