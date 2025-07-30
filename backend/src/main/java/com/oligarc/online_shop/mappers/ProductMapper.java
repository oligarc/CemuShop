package com.oligarc.online_shop.mappers;

import com.oligarc.online_shop.DTO.ProductDTO;
import com.oligarc.online_shop.model.Product;

public class ProductMapper {

    public static ProductDTO convertToProductDTO(Product product){
        return new ProductDTO(product.getId(), product.getName(), product.getDescripcion());
    }
}
