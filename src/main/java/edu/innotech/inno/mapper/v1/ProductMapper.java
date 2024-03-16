package edu.innotech.inno.mapper.v1;

import edu.innotech.inno.model.Product;
import edu.innotech.inno.web.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final ProductRegisterMapper productRegisterMapper;

    public Product requestToProduct(UpsertProductRequest request) {
        Product product = new Product();
        
        product.setProductCodeId(request.getProductCodId());
        product.setClientId(request.getClientId());
        product.setType(request.getType());
        product.setNumber(request.getNumber());
        product.setPriority(request.getPriority());
        product.setDateOfConclusion(request.getDateOfConclusion());
        product.setStartDateTime(request.getStartDateTime());
        product.setEndDateTime(request.getEndDateTime());
        product.setDays(request.getDays());
        product.setPenaltyRate(request.getPenaltyRate());
        product.setNso(request.getNso());
        product.setThreshOldAmount(request.getThreshOldAmount());
        product.setRequisiteType(request.getRequisiteType());
        product.setInterestRateType(request.getInterestRateType());
        product.setTaxRate(request.getTaxRate());
        product.setReasoneClose(request.getReasoneClose());
        product.setState(request.getState());

        return product;
    }

    public Product requestToProduct(Long productId, UpsertProductRequest request) {
        Product product = requestToProduct(request);
        product.setId(productId);

        return product;
    }

    public ProductResponse productToResponse (Product product) {
        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(product.getId());
        productResponse.setProductCodeId(product.getProductCodeId());
        productResponse.setClientId(product.getClientId());
        productResponse.setType(product.getType());
        productResponse.setNumber(product.getNumber());
        productResponse.setPriority(product.getPriority());
        productResponse.setDateOfConclusion(product.getDateOfConclusion());
        productResponse.setStartDateTime(product.getStartDateTime());
        productResponse.setEndDateTime(product.getEndDateTime());
        productResponse.setDays(product.getDays());
        productResponse.setPenaltyRate(product.getPenaltyRate());
        productResponse.setNso(product.getNso());
        productResponse.setThreshOldAmount(product.getThreshOldAmount());
        productResponse.setRequisiteType(product.getRequisiteType());
        productResponse.setInterestRateType(product.getInterestRateType());
        productResponse.setTaxRate(product.getTaxRate());
        productResponse.setReasoneClose(product.getReasoneClose());
        productResponse.setState(product.getState());
        productResponse.setProductRegisters(productRegisterMapper.productRegisterListToResponseList(product.getProductRegisters()));

        return productResponse;
    }

//    public List<ProductResponse> productRegisterListToResponseList(List<ProductRegister> productRegisters) {
//        return productRegisters
//                .stream()
//                .map(this::productRegisterToResponse)
//                .collect(Collectors.toList());
//    }

    public ProductListResponse productListToProductResponseList(List<Product> products) {
        ProductListResponse response = new ProductListResponse();
        response.setProducts(products.stream().map(this::productToResponse).collect(Collectors.toList()));

        return response;
    }
}
