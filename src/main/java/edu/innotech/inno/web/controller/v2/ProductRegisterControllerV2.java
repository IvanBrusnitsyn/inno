package edu.innotech.inno.web.controller.v2;

import edu.innotech.inno.mapper.v1.ProductRegisterMapper;
import edu.innotech.inno.model.ProductRegister;
import edu.innotech.inno.service.ProductRegisterService;
import edu.innotech.inno.web.model.ProductRegisterListResponse;
import edu.innotech.inno.web.model.ProductRegisterResponse;
import edu.innotech.inno.web.model.UpsertProductRegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/productregister")
@RequiredArgsConstructor
public class ProductRegisterControllerV2 {
//    private final ProductRegisterService databaseProductRegisterService;
//
//    private final ProductRegisterMapper productRegisterMapper;
//
//    @GetMapping
//    public ResponseEntity<ProductRegisterListResponse> findAll() {
//        return ResponseEntity.ok(
//                productRegisterMapper.productRegisterListToProductRegisterListResponse(databaseProductRegisterService.findAll())
//        );
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<ProductRegisterResponse> findById(@PathVariable Long id) {
//        return ResponseEntity.ok(
//                productRegisterMapper.productRegisterToResponse(databaseProductRegisterService.findById(id))
//        );
//    }
//
//    @PostMapping
//    public ResponseEntity<ProductRegisterResponse> create(@RequestBody @Valid UpsertProductRegisterRequest request) {
//        ProductRegister newProductRegister = databaseProductRegisterService.save(
//                productRegisterMapper.requestToProductRegister(request));
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(productRegisterMapper.productRegisterToResponse(newProductRegister));
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<ProductRegisterResponse> update(@PathVariable("id") Long productRegisterId,
//                                                          @RequestBody @Valid UpsertProductRegisterRequest request) {
//        ProductRegister updatedProductRegister = databaseProductRegisterService.update(
//                productRegisterMapper.requestToProductRegister(productRegisterId, request));
//
//        return ResponseEntity.ok(productRegisterMapper.productRegisterToResponse(updatedProductRegister));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        databaseProductRegisterService.deleteById(id);
//
//        return ResponseEntity.noContent().build();
//    }

}
