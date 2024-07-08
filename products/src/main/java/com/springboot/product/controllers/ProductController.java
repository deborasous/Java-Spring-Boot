package com.springboot.product.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.product.dtos.ProductRecordDto;
import com.springboot.product.models.ProductModel;
import com.springboot.product.repositories.ProductRepository;
import com.springboot.product.responses.ApiResponse;

import jakarta.validation.Valid;

@RestController
public class ProductController {
  private final ProductRepository productRepository;

  @Autowired
  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @PostMapping("/produtos")
  public ResponseEntity<ApiResponse<ProductModel>> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
    var productModel = new ProductModel();
    BeanUtils.copyProperties(productRecordDto, productModel);
    ProductModel saveProduct = productRepository.save(productModel);

    ApiResponse<ProductModel> response = new ApiResponse<>("Produto cadastrado com sucesso!", saveProduct);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
}
