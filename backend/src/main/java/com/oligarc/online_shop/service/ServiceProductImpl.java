package com.oligarc.online_shop.service;

import com.oligarc.online_shop.DTO.ProductDTO;
import com.oligarc.online_shop.exceptions.ProductNotFoundException;
import com.oligarc.online_shop.mappers.ProductMapper;
import com.oligarc.online_shop.model.Product;
import com.oligarc.online_shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductImpl implements ServiceProduct{

    private ProductRepository productRepository;

    public ServiceProductImpl(ProductRepository v_productRepository){
        this.productRepository=v_productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::convertToProductDTO)
                .toList();
    }

    @Override
    public ProductDTO getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("No existe un producto con ese id"));
        return ProductMapper.convertToProductDTO(product);
    }

    @Override
    public List<ProductDTO> getProductsByName(String name) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        return products
                .stream()
                .map(ProductMapper::convertToProductDTO)
                .toList();
    }

    @Override
    public ProductDTO addProduct(Product product) {
        productRepository.save(product);
        return ProductMapper.convertToProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Product product, int id) {
        Product productUpdated = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("No existe un producto con ese id"));
        productUpdated.setName(product.getName());
        productUpdated.setDescripcion(product.getDescripcion());
        productRepository.save(productUpdated);
        return ProductMapper.convertToProductDTO(productUpdated);
    }

    @Override
    public void deleteProduct(int id) {
        Product productToDelete = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("No existe un producto con ese id"));
        productRepository.delete(productToDelete);
    }
}
