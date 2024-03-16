package edu.innotech.inno.web.controller.v1;

import edu.innotech.inno.AbstractTestController;
import edu.innotech.inno.StringTestUtils;
import edu.innotech.inno.exception.EntityNotFoundException;
import edu.innotech.inno.mapper.v1.ProductMapper;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.service.ProductService;
import edu.innotech.inno.web.model.ProductListResponse;
import edu.innotech.inno.web.model.ProductRegisterResponse;
import edu.innotech.inno.web.model.ProductResponse;
import edu.innotech.inno.web.model.UpsertProductRequest;
import net.bytebuddy.utility.RandomString;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest extends AbstractTestController {

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductMapper productMapper;

    @Test
    public void whenFindAll_thenReturnAllProducts() throws Exception{
        List<Product> products = new ArrayList<>();
        ProductRegister productRegister = createProductRegister(1L,null);
        products.add(createProduct(1L, productRegister));

        List<ProductResponse> productResponses = new ArrayList<>();
        ProductRegisterResponse productRegisterResponse = createProductRegisterResponse(1L);
        productResponses.add(createProductResponse(1L,productRegisterResponse));

        ProductListResponse productListResponse = new ProductListResponse(productResponses);

        Mockito.when(productService.findAll()).thenReturn(products);

        Mockito.when(productMapper.productListToProductResponseList(products)).thenReturn(productListResponse);

        String actualResponse = mockMvc.perform(get("/api/v1/product"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        String expectedResponse = StringTestUtils.readStringFromResource("response/find_all_products_response.json");

        Mockito.verify(productService, Mockito.times(1)).findAll();
        Mockito.verify(productMapper, Mockito.times(1)).productListToProductResponseList(products);
        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
    }

    @Test
    public void whenCreateProduct_thenReturnNewProduct() throws Exception{
        Product product = new Product();
        product.setProductCodeId(BigInteger.valueOf(1));
        product.setClientId(BigInteger.valueOf(1));
        product.setType("Type1");
        product.setNumber("Number1");
        product.setPriority(BigInteger.valueOf(1));
        product.setDateOfConclusion(Instant.parse("2024-03-10T10:00:00.00Z"));
        product.setStartDateTime(Instant.parse("2024-03-10T10:00:00.00Z"));
        product.setEndDateTime(Instant.parse("2024-03-10T10:00:00.00Z"));
        product.setDays(BigInteger.valueOf(1));
        product.setPenaltyRate(BigDecimal.valueOf(10.01));
        product.setNso(BigDecimal.valueOf(100.01));
        product.setThreshOldAmount(BigDecimal.valueOf(1000.01));
        product.setRequisiteType("RegisterType");
        product.setInterestRateType("InterestRateType");
        product.setTaxRate(BigDecimal.valueOf(10000.01));
        product.setReasoneClose("ReasoneClose");
        product.setState("State");

        Product createProduct = createProduct(1L, null);

        ProductResponse productResponse = createProductResponse(1L,null);
        UpsertProductRequest request = new UpsertProductRequest(BigInteger.valueOf(1),BigInteger.valueOf(1),"Type1","Number1",BigInteger.valueOf(1),Instant.parse("2024-03-10T10:00:00.00Z"),Instant.parse("2024-03-10T10:00:00.00Z"),
                Instant.parse("2024-03-10T10:00:00.00Z"),BigInteger.valueOf(1),BigDecimal.valueOf(10.01),BigDecimal.valueOf(100.01),BigDecimal.valueOf(1000.01),"RegisterType","InterestRateType",
                BigDecimal.valueOf(10000.01),"ReasoneClose","State");

        Mockito.when(productService.save(product)).thenReturn(createProduct);
        Mockito.when(productMapper.requestToProduct(request)).thenReturn(product);
        Mockito.when(productMapper.productToResponse(createProduct)).thenReturn(productResponse);


        String actualResponse = mockMvc.perform(post("/api/v1/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        String expectedResponse = StringTestUtils.readStringFromResource("response/create_product_response.json");

        Mockito.verify(productService, Mockito.times(1)).save(product);
        Mockito.verify(productMapper, Mockito.times(1)).requestToProduct(request);
        Mockito.verify(productMapper, Mockito.times(1)).productToResponse(createProduct);

        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
    }

    @Test
    public void whenFindByIdNotExistedProduct_thenReturnError() throws Exception{
        Mockito.when(productService.findById(100L)).thenThrow(new EntityNotFoundException("Продукт с id 100 не найден!"));

        var response = mockMvc.perform(get("/api/v1/product/100"))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse();

        response.setCharacterEncoding("UTF-8");

        String actualResponse = response.getContentAsString();
        String expectedResponse = StringTestUtils.readStringFromResource("response/product_by_id_not_found_response.json");

        Mockito.verify(productService, Mockito.times(1)).findById(100L);

        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
    }

    @Test
    public void whenCreateProductWithEmptyNumber_thenReturnError() throws Exception{
        var response = mockMvc.perform(post("/api/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new UpsertProductRequest())))
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse();

        response.setCharacterEncoding("UTF-8");

        String actualResponse = response.getContentAsString();
        String expectedResponse = StringTestUtils.readStringFromResource("response/empty_product_number_response.json");

        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
    }

    @ParameterizedTest
    @MethodSource("invalidSizeNumber")
    public void whenCreateProductWithInvalidSizeNumber_thenReturnError(String numberProd) throws Exception{
        var response = mockMvc.perform(post("/api/v1/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new UpsertProductRequest(BigInteger.valueOf(1),BigInteger.valueOf(1),"Type1",numberProd,BigInteger.valueOf(1),Instant.parse("2024-03-10T10:00:00.00Z"),Instant.parse("2024-03-10T10:00:00.00Z"),
                                Instant.parse("2024-03-10T10:00:00.00Z"),BigInteger.valueOf(1),BigDecimal.valueOf(10.01),BigDecimal.valueOf(100.01),BigDecimal.valueOf(1000.01),"RegisterType","InterestRateType",
                                BigDecimal.valueOf(10000.01),"ReasoneClose","State"))))
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse();

        response.setCharacterEncoding("UTF-8");

        String actualResponse = response.getContentAsString();
        String expectedResponse = StringTestUtils.readStringFromResource("response/product_number_size_exception_response.json");

        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);

    }

    private static Stream<Arguments> invalidSizeNumber() {
        return Stream.of(
//                Arguments.of(RandomString.make(2)),
                Arguments.of(RandomString.make(51))
        );
    }

}
