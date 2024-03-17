package edu.innotech.inno.web.controller.v3;

import edu.innotech.inno.mapper.v1.ProductMapper;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.service.ProductService;
import edu.innotech.inno.web.model.ProductListResponse;
import edu.innotech.inno.web.model.ProductResponse;
import edu.innotech.inno.web.model.UpsertProductRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/product")
@RequiredArgsConstructor
public class ProductControllerV3 {
    @Autowired
    private final ProductService databaseProductService; //productService

    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<ProductListResponse> findAll() {
        List<Product> listPr = databaseProductService.findAll();
        listPr.forEach(System.out::println);
        System.out.println("Выводим все записи из БД");
        return ResponseEntity.ok(
                productMapper.productListToProductResponseList(databaseProductService.findAll())
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                productMapper.productToResponse(databaseProductService.findById(id))
        );
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid UpsertProductRequest request) {
        Product newProduct = databaseProductService.save(productMapper.requestToProduct(request));

        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(productMapper.productToResponse(newProduct));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable("id") Long productId,
                                                  @RequestBody UpsertProductRequest request) {
        Product updatedProduct = databaseProductService.update(productMapper.requestToProduct(productId, request));

        return ResponseEntity.ok(productMapper.productToResponse(updatedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        databaseProductService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
