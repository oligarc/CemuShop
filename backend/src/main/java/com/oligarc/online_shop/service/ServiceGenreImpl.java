package com.oligarc.online_shop.service;

import com.oligarc.online_shop.DTO.GenreDTO;
import com.oligarc.online_shop.exceptions.GenreNotFoundException;
import com.oligarc.online_shop.mappers.GenreMapper;
import com.oligarc.online_shop.model.Genre;
import com.oligarc.online_shop.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceGenreImpl implements ServiceGenre{

    private GenreRepository genreRepository;

    @Autowired
    public ServiceGenreImpl(GenreRepository v_genreRepository){
        this.genreRepository=v_genreRepository;
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        return genreRepository.findAll()
                .stream()
                .map(GenreMapper::convertToGenreDTO)
                .toList();
    }

    @Override
    public GenreDTO getByGenreId(int id) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException("No existe un género con ese id"));
        return GenreMapper.convertToGenreDTO(genre);
    }

    @Override
    public GenreDTO saveGenre(Genre genre) {
        genreRepository.save(genre);
        return GenreMapper.convertToGenreDTO(genre);
    }

    @Override
    public GenreDTO updateGenre(Genre genre, int id) {
        Genre genre1 = genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException("No existe un género con ese id"));
        genre1.setName(genre.getName());
        genreRepository.save(genre1);
        return GenreMapper.convertToGenreDTO(genre1);
    }

    @Override
    public void deleteGenre(int id) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException("No existe un género con ese id"));
        genreRepository.delete(genre);
    }
}
