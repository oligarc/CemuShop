package com.oligarc.online_shop.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantDTO {

    private int id;
    private String size;
    private String color;
    private int stock;
    private String photoUrl;
    private BigDecimal price;
    private int genreId;
    private int categoryId;
    private int productId;


}
