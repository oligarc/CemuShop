package com.oligarc.online_shop.service;

import com.oligarc.online_shop.DTO.ProductVariantDTO;
import com.oligarc.online_shop.mappers.ProductVariantMapper;
import com.oligarc.online_shop.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductVariantImpl implements ServiceProductVariant {

    private ProductVariantRepository productVariantRepository;

    @Autowired
    public ServiceProductVariantImpl(ProductVariantRepository v_productVariantRepository){
        this.productVariantRepository=v_productVariantRepository;
    }


    @Override
    public List<ProductVariantDTO> getAllProductVariants() {
        return productVariantRepository.findAll()
                .stream()
                .map(ProductVariantMapper::convertToProductVariantDTO)
                .toList();
    }
}
