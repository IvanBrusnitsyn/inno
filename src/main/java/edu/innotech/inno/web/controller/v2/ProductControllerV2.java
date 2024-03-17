package edu.innotech.inno.web.controller.v2;

import edu.innotech.inno.mapper.v2.ProductMapperV2;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.service.ProductService;
import edu.innotech.inno.web.model.ProductListResponse;
import edu.innotech.inno.web.model.ProductResponse;
import edu.innotech.inno.web.model.UpsertProductRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/product")
@RequiredArgsConstructor
public class ProductControllerV2 {
//    private final ProductService databaseProductService;
//    private final ProductMapperV2 productMapper;

//    @GetMapping
//    public ResponseEntity<ProductListResponse> findAll() {
//        return ResponseEntity.ok(
//                productMapper.productListToProductResponseList(databaseProductService.findAll())
//        );
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
//        return ResponseEntity.ok(
//                productMapper.productToResponse(databaseProductService.findById(id))
//        );
//    }
//
//    @PostMapping
//    public ResponseEntity<ProductResponse> create(@RequestBody @Valid UpsertProductRequest request) {
//        Product newProduct = databaseProductService.save(productMapper.requestToProduct(request));
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(productMapper.productToResponse(newProduct));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ProductResponse> update(@PathVariable("id") Long productId,
//                                                  @RequestBody @Valid UpsertProductRequest request) {
//        Product updatedProduct = databaseProductService.update(productMapper.requestToProduct(productId, request));
//
//        return ResponseEntity.ok(productMapper.productToResponse(updatedProduct));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        databaseProductService.deleteById(id);
//
//        return ResponseEntity.noContent().build();
//
//    }
}
