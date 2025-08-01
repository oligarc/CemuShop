package com.oligarc.online_shop.service;

import com.oligarc.online_shop.DTO.ProductDTO;
import com.oligarc.online_shop.model.Product;

import java.util.List;

public interface ServiceProduct {
    public List<ProductDTO> getAllProducts();
    public ProductDTO getProductById(int id);
    public List<ProductDTO> getProductsByName(String name);
    public ProductDTO addProduct(Product product);
    public ProductDTO updateProduct(Product product, int id);
    public void deleteProduct(int id);
}
