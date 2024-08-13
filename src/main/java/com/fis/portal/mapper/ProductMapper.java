package com.fis.portal.mapper;

import java.util.List;

import com.fis.portal.model.Product;

public interface ProductMapper {
    List<Product> search(Product payload);
    int count(Product payload);
    int create(Product product);
    int update(Product product);
    Product findByCode(String code);
}