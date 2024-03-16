package edu.innotech.inno.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertProductRequest {

    private BigInteger productCodId;
    private BigInteger clientId;
    private String type;
    @NotBlank(message = "Номер продукта должен быть заполнен!")
    @Size(max = 50, message = "Номер продукта не может быть больше {max}!")
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
