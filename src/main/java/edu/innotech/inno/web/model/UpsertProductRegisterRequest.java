package edu.innotech.inno.web.model;

import edu.innotech.inno.model.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigInteger;

@Data
public class UpsertProductRegisterRequest {
    @NotNull(message = "ID продукта должно быть указано!")
    @Positive(message = "ID продукта должно быть больше 0!")
    private Long productId;
    private String type;
    private BigInteger account;
    private String currencyCode;
    private String state;
    private String accountNumber;
}
