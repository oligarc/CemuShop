package com.oligarc.online_shop.service;

import com.oligarc.online_shop.DTO.GenreDTO;
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
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe un género con ese id"));
        return GenreMapper.convertToGenreDTO(genre);
    }

    @Override
    public GenreDTO saveGenre(Genre genre) {
        genreRepository.save(genre);
        return GenreMapper.convertToGenreDTO(genre);
    }

    @Override
    public void deleteGenre(int id) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe un género con ese id"));
        genreRepository.deleteById(id);
    }
}
