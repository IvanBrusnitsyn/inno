package edu.innotech.inno.mapper.v2;

import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.service.ProductService;
import edu.innotech.inno.web.model.UpsertProductRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProductRegisterMapperDelegate implements ProductRegisterMapperV2{
//    @Autowired
//    private ProductService databaseProductService;
//
//
//    @Override
//    public ProductRegister requestToProductRegister(UpsertProductRegisterRequest request) {
//        ProductRegister productRegister = new ProductRegister();
//        productRegister.setType(request.getType());
//        productRegister.setAccount(request.getAccount());
//        productRegister.setCurrencyCode(request.getCurrencyCode());
//        productRegister.setState(request.getState());
//        productRegister.setAccountNumber(request.getAccountNumber());
//        productRegister.setProductId(databaseProductService.findById(request.getProductId()));
//
//        return productRegister;
//    }
//
//    public ProductRegister requestToProductRegister(Long productRegisterId, UpsertProductRegisterRequest request) {
//        ProductRegister productRegister = requestToProductRegister(request);
//        productRegister.setId(productRegisterId);
//
//        return productRegister;
//    }


}
