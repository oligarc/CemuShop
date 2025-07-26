package com.oligarc.online_shop.repository;

import com.oligarc.online_shop.model.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant,Integer> {
}
