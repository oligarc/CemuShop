package com.oligarc.online_shop.restController;

import com.oligarc.online_shop.DTO.GenreDTO;
import com.oligarc.online_shop.handler.ResponseHandler;
import com.oligarc.online_shop.model.Genre;
import com.oligarc.online_shop.service.ServiceGenre;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private ServiceGenre serviceGenre;
    private static final Logger logger = LoggerFactory.getLogger(GenreController.class);

    public GenreController(ServiceGenre v_serviceGenre) {
        this.serviceGenre = v_serviceGenre;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllGenres() {

        try {
            List<GenreDTO> genres = serviceGenre.getAllGenres();
            if (genres.isEmpty()) {
                return ResponseHandler.error("No se encontraron géneros", HttpStatus.NOT_FOUND);
            }

            return ResponseHandler.success("Géneros cargados con éxito", genres);

        } catch (Exception e) {
            return ResponseHandler.error("Error al cargar los géneros", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenreById(@PathVariable int id){
        try {

            GenreDTO genreDTO = serviceGenre.getByGenreId(id);
            if(genreDTO == null){
                return ResponseHandler.error("Problema con el id " +id , HttpStatus.NOT_FOUND);
            }

            return ResponseHandler.success("Género obtenido con éxito", genreDTO);

        } catch (Exception e) {
            logger.error("Error al obtener el género con id: " + id, e);
            return ResponseHandler.error("Error al obtener el género", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> addGenre(@Valid @RequestBody Genre genre, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResponseHandler.error("Datos inválidos " +bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        try {
            serviceGenre.saveGenre(genre);
            return ResponseHandler.success("Género guardado con éxito", genre);
        }catch (Exception e){
            logger.error("Error al guardar el género con id " +genre.getId(), e);
            return ResponseHandler.error("Error al guardar el género", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable int id){
        try {
            GenreDTO genreToDelete = serviceGenre.getByGenreId(id);
            serviceGenre.deleteGenre(id);
            return ResponseHandler.success("Género con id " + id + " eliminado correctamente." ,genreToDelete);

        } catch (Exception e) {
            logger.error("Error al eliminar el género con id " +id , e);
            return ResponseHandler.error("Error al eliminar el género", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

