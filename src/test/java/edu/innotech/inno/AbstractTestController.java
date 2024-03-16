package edu.innotech.inno;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.web.model.ProductRegisterResponse;
import edu.innotech.inno.web.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public abstract class AbstractTestController {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected Product createProduct(Long id, ProductRegister productRegister){
        Product product = new Product(
                id,
                BigInteger.valueOf(id),
                BigInteger.valueOf(id),
                "Type"+id,
                "Number"+id,
                BigInteger.valueOf(1),
                Instant.parse("2024-03-10T10:00:00.00Z"),
                Instant.parse("2024-03-10T10:00:00.00Z"),
                Instant.parse("2024-03-10T10:00:00.00Z"),
                BigInteger.valueOf(1),
                BigDecimal.valueOf(10.01),
                BigDecimal.valueOf(100.01),
                BigDecimal.valueOf(1000.01),
                "RegisterType",
                "InterestRateType",
                BigDecimal.valueOf(10000.01),
                "ReasoneClose",
                "State",
                new ArrayList<>()
        );
        if(productRegister != null){
            productRegister.setProductId(product);
            product.addProductRegister(productRegister);
        }
        return product;
    }

    protected ProductRegister createProductRegister(Long id, Product product){
        ProductRegister productRegister = new ProductRegister(
                id,
                product,
                "Type",
                BigInteger.valueOf(id),
                "CurrencyCode",
                "State",
                "AccountNumber"
        );
        return productRegister;
    }

    protected ProductResponse createProductResponse(Long id, ProductRegisterResponse productRegisterResponse){
        ProductResponse productResponse = new ProductResponse(
                id,
                BigInteger.valueOf(id),
                BigInteger.valueOf(id),
                "Type"+id,
                "Number"+id,
                BigInteger.valueOf(1),
                Instant.parse("2024-03-10T10:00:00.00Z"),
                Instant.parse("2024-03-10T10:00:00.00Z"),
                Instant.parse("2024-03-10T10:00:00.00Z"),
                BigInteger.valueOf(1),
                BigDecimal.valueOf(10.01),
                BigDecimal.valueOf(100.01),
                BigDecimal.valueOf(1000.01),
                "RegisterType",
                "InterestRateType",
                BigDecimal.valueOf(10000.01),
                "ReasoneClose",
                "State",
                new ArrayList<>()
        );

        if (productRegisterResponse != null) {
            productResponse.getProductRegisters().add(productRegisterResponse);
        }
        return productResponse;
    }

    protected ProductRegisterResponse createProductRegisterResponse(Long id) {
        return new ProductRegisterResponse(
                id,
                "Type",
                BigInteger.valueOf(id),
                "CurrencyCode",
                "State",
                "AccountNumber"
        );
    }
}
