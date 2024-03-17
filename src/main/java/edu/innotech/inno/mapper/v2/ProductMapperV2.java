package edu.innotech.inno.mapper.v2;

import edu.innotech.inno.model.Product;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.web.model.*;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ProductRegisterMapperV2.class})
public interface ProductMapperV2 {
//
//    Product requestToProduct(UpsertProductRequest request);
//    @Mapping(source = "productId", target = "id")
//    Product requestToProduct(Long productId, UpsertProductRequest request);
//
//    ProductResponse productToResponse (Product product);
//
//    default ProductListResponse productListToProductResponseList (
//            List<Product> products) {
//        ProductListResponse response = new ProductListResponse();
//        response.setProducts(products.stream()
//                .map(this::productToResponse).collect(Collectors.toList()));
//
//        return response;
//    }
}
