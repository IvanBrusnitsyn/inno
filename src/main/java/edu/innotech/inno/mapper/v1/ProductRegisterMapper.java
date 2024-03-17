package edu.innotech.inno.mapper.v1;

import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.service.ProductService;
import edu.innotech.inno.web.model.ProductRegisterListResponse;
import edu.innotech.inno.web.model.ProductRegisterResponse;
import edu.innotech.inno.web.model.UpsertProductRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductRegisterMapper {
    private final ProductService productServiceImpl; //productService
    public ProductRegister requestToProductRegister(UpsertProductRegisterRequest request) {
        ProductRegister productRegister = new ProductRegister();

        productRegister.setType(request.getType());
        productRegister.setAccount(request.getAccount());
        productRegister.setCurrencyCode(request.getCurrencyCode());
        productRegister.setState(request.getState());
        productRegister.setAccountNumber(request.getAccountNumber());
        productRegister.setProductId(productServiceImpl.findById(request.getProductId())); //productService

        return productRegister;
    }
    public ProductRegister requestToProductRegister(Long productRegisterId, UpsertProductRegisterRequest request) {
        ProductRegister productRegister = requestToProductRegister(request);
        productRegister.setId(productRegisterId);

        return productRegister;
    }

    public ProductRegisterResponse productRegisterToResponse(ProductRegister productRegister) {
        ProductRegisterResponse productRegisterResponse = new ProductRegisterResponse();

        productRegisterResponse.setId(productRegister.getId());
        productRegisterResponse.setType(productRegister.getType());
        productRegisterResponse.setAccount(productRegister.getAccount());
        productRegisterResponse.setCurrencyCode(productRegister.getCurrencyCode());
        productRegisterResponse.setState(productRegister.getState());
        productRegisterResponse.setAccountNumber(productRegister.getAccountNumber());

        return productRegisterResponse;
    }

    public List<ProductRegisterResponse> productRegisterListToResponseList(List<ProductRegister> productRegisters) {
        return productRegisters
                .stream()
                .map(this::productRegisterToResponse)
                .collect(Collectors.toList());
    }

    public ProductRegisterListResponse productRegisterListToProductRegisterListResponse(List<ProductRegister> productRegisters) {
        ProductRegisterListResponse response = new ProductRegisterListResponse();
        response.setProductRegisters(productRegisterListToResponseList(productRegisters));

        return response;
    }

}
