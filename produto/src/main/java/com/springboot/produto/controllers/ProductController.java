package com.springboot.produto.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.produto.dtos.ProductRecordDto;
import com.springboot.produto.models.ProdutoModel;
import com.springboot.produto.repositories.ProductRepository;
import com.springboot.produto.responses.ApiResponse;

import jakarta.validation.Valid;

@RestController
public class ProductController {
  private final ProductRepository productRepository;

  @Autowired
  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @PostMapping("/produtos")
  public ResponseEntity<ApiResponse<ProdutoModel>> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
    var produtoModel = new ProdutoModel();
    BeanUtils.copyProperties(productRecordDto, produtoModel);
    ProdutoModel saveProduct = productRepository.save(produtoModel);

    ApiResponse<ProdutoModel> response = new ApiResponse<>("Produto cadastrado com sucesso!", saveProduct);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
}
