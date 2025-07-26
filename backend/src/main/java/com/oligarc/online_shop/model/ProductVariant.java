package com.oligarc.online_shop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_variant")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_variant_id_gen")
    @SequenceGenerator(name = "product_variant_id_gen", sequenceName = "product_variant_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "size", nullable = false, length = 10)
    private String size;

    @Column(name = "color", nullable = false, length = 30)
    private String color;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "photo_url", length = 250)
    private String photoUrl;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "productVariant")
    private Set<BasketDetail> basketDetails = new LinkedHashSet<>();

}