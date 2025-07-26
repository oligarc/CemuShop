package com.oligarc.online_shop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "basket_id_gen")
    @SequenceGenerator(name = "basket_id_gen", sequenceName = "basket_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.oligarc.online_shop.model.User user;

    @ColumnDefault("'active'")
    @Column(name = "status", length = 20)
    private String status;

    @OneToMany(mappedBy = "basket")
    private Set<com.oligarc.online_shop.model.BasketDetail> basketDetails = new LinkedHashSet<>();

}