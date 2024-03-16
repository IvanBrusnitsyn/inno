package edu.innotech.inno.web.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductListResponse {

    private List<ProductResponse> products = new ArrayList<>();
}
