package com.pacom.swagger2.services;

import com.pacom.swagger2.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(long id);
}