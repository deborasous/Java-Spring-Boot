package com.springboot.product.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.product.models.ProductModel;

// A anotação @Repository no Spring é utilizada para indicar que a classe anotada é um repositório, que é um componente responsável por encapsular a lógica de armazenamento, recuperação e busca de dados. No Spring Data JPA um repositório interagem com o banco de dados relacional.
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

}
