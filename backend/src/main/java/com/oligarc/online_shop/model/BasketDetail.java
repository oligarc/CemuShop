package com.oligarc.online_shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "basket_detail")
public class BasketDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "basket_detail_id_gen")
    @SequenceGenerator(name = "basket_detail_id_gen", sequenceName = "basket_detail_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "basket_id", nullable = false)
    private Basket basket;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_variant_id", nullable = false)
    private com.oligarc.online_shop.model.ProductVariant productVariant;

    @ColumnDefault("1")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}