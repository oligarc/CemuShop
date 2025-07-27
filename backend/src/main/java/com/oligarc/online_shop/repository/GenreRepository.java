package com.oligarc.online_shop.repository;

import com.oligarc.online_shop.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
}
