package com.pacom.swagger2.repositories;

import com.pacom.swagger2.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    Product findById(Integer id);
}