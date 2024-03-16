package edu.innotech.inno.web.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

@Data
public class UpsertProductRequest {
    private BigInteger productCodId;
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
}
