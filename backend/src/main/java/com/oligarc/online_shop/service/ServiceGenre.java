package com.oligarc.online_shop.service;

import com.oligarc.online_shop.DTO.GenreDTO;
import com.oligarc.online_shop.model.Genre;

import java.util.List;

public interface ServiceGenre {
    public List<GenreDTO> getAllGenres();
    public GenreDTO getByGenreId(int id);
    public GenreDTO saveGenre(Genre genre);
    public void deleteGenre(int id);
}
