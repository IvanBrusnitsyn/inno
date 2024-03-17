package edu.innotech.inno.web.controller.v1;

import edu.innotech.inno.mapper.v1.ProductRegisterMapper;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.service.ProductRegisterService;
import edu.innotech.inno.web.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/productregister")
@RequiredArgsConstructor
public class ProductRegisterController {
    private final ProductRegisterService productRegisterServiceImpl; //productRegisterService

    private final ProductRegisterMapper productRegisterMapper;

    @GetMapping
    public ResponseEntity<ProductRegisterListResponse> findAll() {
        return ResponseEntity.ok(
                productRegisterMapper.productRegisterListToProductRegisterListResponse(productRegisterServiceImpl.findAll())
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductRegisterResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                productRegisterMapper.productRegisterToResponse(productRegisterServiceImpl.findById(id))
        );
    }

    @PostMapping
    public ResponseEntity<ProductRegisterResponse> create(@RequestBody UpsertProductRegisterRequest request) {
        ProductRegister newProductRegister = productRegisterServiceImpl.save(productRegisterMapper.requestToProductRegister(request));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productRegisterMapper.productRegisterToResponse(newProductRegister));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductRegisterResponse> update(@PathVariable("id") Long productRegisterId,
                                                  @RequestBody UpsertProductRegisterRequest request) {
        ProductRegister updatedProductRegister = productRegisterServiceImpl.update(
                productRegisterMapper.requestToProductRegister(productRegisterId, request));

        return ResponseEntity.ok(productRegisterMapper.productRegisterToResponse(updatedProductRegister));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productRegisterServiceImpl.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
