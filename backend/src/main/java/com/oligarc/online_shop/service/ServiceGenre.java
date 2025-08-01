package com.oligarc.online_shop.service;

import com.oligarc.online_shop.DTO.GenreDTO;
import com.oligarc.online_shop.model.Genre;

import java.util.List;

public interface ServiceGenre {
    public List<GenreDTO> getAllGenres();
    public GenreDTO getByGenreId(int id);
    public GenreDTO addGenre(Genre genre);
    public GenreDTO updateGenre(Genre genre, int id);
    public void deleteGenre(int id);
}
