package com.oligarc.online_shop.mappers;

import com.oligarc.online_shop.DTO.ProductVariantDTO;
import com.oligarc.online_shop.model.ProductVariant;

public class ProductVariantMapper {

    public static ProductVariantDTO convertToProductVariantDTO(ProductVariant productVariant){
        return new ProductVariantDTO(
                productVariant.getId(),productVariant.getSize(),productVariant.getColor(), productVariant.getStock(),productVariant.getPhotoUrl(),productVariant.getPrice(),productVariant.getGenre().getId(),productVariant.getCategory().getId(),productVariant.getProduct().getId()
        );
    }
}
