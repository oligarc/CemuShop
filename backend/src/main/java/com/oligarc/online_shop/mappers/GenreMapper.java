package com.oligarc.online_shop.mappers;

import com.oligarc.online_shop.DTO.GenreDTO;
import com.oligarc.online_shop.model.Genre;

public class GenreMapper {

    public static GenreDTO convertToGenreDTO(Genre genre){
        return new GenreDTO(genre.getId(), genre.getName());
    }
}
