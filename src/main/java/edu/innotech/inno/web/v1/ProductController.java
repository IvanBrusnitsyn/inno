package edu.innotech.inno.web.v1;

import edu.innotech.inno.mapper.v1.ProductMapper;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.service.ProductService;
import edu.innotech.inno.web.model.ProductListResponse;
import edu.innotech.inno.web.model.ProductResponse;
import edu.innotech.inno.web.model.UpsertProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<ProductListResponse> findAll() {
        return ResponseEntity.ok(
                productMapper.productListToProductResponseList(productService.findAll())
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                productMapper.productToResponse(productService.findById(id))
        );
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody UpsertProductRequest request) {
        Product newProduct = productService.save(productMapper.requestToProduct(request));

        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(productMapper.productToResponse(newProduct));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable("id") Long productId,
                                                  @RequestBody UpsertProductRequest request) {
        Product updatedProduct = productService.update(productMapper.requestToProduct(productId, request));

        return ResponseEntity.ok(productMapper.productToResponse(updatedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
