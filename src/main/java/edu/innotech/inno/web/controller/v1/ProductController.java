package edu.innotech.inno.web.controller.v1;

import edu.innotech.inno.mapper.v1.ProductMapper;
import edu.innotech.inno.model.Product;
import edu.innotech.inno.service.ProductService;
import edu.innotech.inno.web.model.ProductListResponse;
import edu.innotech.inno.web.model.ProductResponse;
import edu.innotech.inno.web.model.UpsertProductRequest;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productServiceImpl; //productService

    private final ProductMapper productMapper;

//    @Operation(
//            summary = "Get Products",
//            description = "Get all Products",
//            tags = {"products"}
//    )
    @GetMapping
    public ResponseEntity<ProductListResponse> findAll() {
        return ResponseEntity.ok(
                productMapper.productListToProductResponseList(productServiceImpl.findAll())
        );
    }

//    @Operation(
//            summary = "Get Product by ID",
//            description = "Get Product by ID. Return all field and list Product registers",
//            tags = {"product", "id"}
//    )
//    @ApiResponses(
//            {
//            @ApiResponse(
//                    responseCode = "200",
//                    content = {
//                            @Content(schema = @Schema(implementation = ProductResponse.class), mediaType = "application/json")
//                    }
//            ),
//            @ApiResponse(
//                    responseCode = "404",
//                    content = {
//                            @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
//                    }
//            )
//                }
//    )
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                productMapper.productToResponse(productServiceImpl.findById(id))
        );
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid UpsertProductRequest request) {
        Product newProduct = productServiceImpl.save(productMapper.requestToProduct(request));

        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(productMapper.productToResponse(newProduct));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable("id") Long productId,
                                                  @RequestBody UpsertProductRequest request) {
        Product updatedProduct = productServiceImpl.update(productMapper.requestToProduct(productId, request));

        return ResponseEntity.ok(productMapper.productToResponse(updatedProduct));
    }

//    @Operation(
//            summary = "Delete Product by ID",
//            description = "Delete Product by ID",
//            tags = {"product", "id"}
//    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productServiceImpl.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<Void> notFoundHamdler(EntityNotFoundException ex) {
//        return ResponseEntity.notFound().build();
//    }
}
