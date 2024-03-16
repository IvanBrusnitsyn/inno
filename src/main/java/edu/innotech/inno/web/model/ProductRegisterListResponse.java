package edu.innotech.inno.web.model;

import edu.innotech.inno.model.ProductRegister;
import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductRegisterListResponse {

    private List<ProductRegisterResponse> productRegisters = new ArrayList<>();

}
