package edu.innotech.inno.mapper.v2;

import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.web.model.ProductRegisterListResponse;
import edu.innotech.inno.web.model.ProductRegisterResponse;
import edu.innotech.inno.web.model.UpsertProductRegisterRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@DecoratedWith(ProductRegisterMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductRegisterMapperV2 {
//        ProductRegister requestToProductRegister(UpsertProductRegisterRequest request);
//        @Mapping(source = "productRegisterId", target = "id")
//        ProductRegister requestToProductRegister(Long productRegisterId, UpsertProductRegisterRequest request);
//
//        ProductRegisterResponse productRegisterToResponse (ProductRegister productRegister);
//
//        List<ProductRegisterResponse> productRegisterListToResponseList (List<ProductRegister> productRegisters);
//
//        default ProductRegisterListResponse productRegisterListToProductRegisterListResponse (
//                List<ProductRegister> productRegisters) {
//                ProductRegisterListResponse response = new ProductRegisterListResponse();
//                response.setProductRegisters(productRegisterListToResponseList(productRegisters));
//
//                return response;
//        }

}
