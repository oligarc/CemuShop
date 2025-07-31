package com.oligarc.online_shop.restController;

import com.oligarc.online_shop.DTO.CategoryDTO;
import com.oligarc.online_shop.DTO.GenreDTO;
import com.oligarc.online_shop.handler.ResponseHandler;
import com.oligarc.online_shop.model.Category;
import com.oligarc.online_shop.service.ServiceCategory;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private ServiceCategory serviceCategory;
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    public CategoryController(ServiceCategory v_serviceCategory){
        this.serviceCategory=v_serviceCategory;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCategories(){

        try {

            List<CategoryDTO> categories = serviceCategory.getAllCategories();
            if(categories.isEmpty()){
                return ResponseHandler.error("No existen categorías", HttpStatus.NOT_FOUND);
            }

            return ResponseHandler.success("Categorías cargadas con éxito", categories);

        } catch (Exception e) {
            logger.error("Error al cargar las categorías", e);
            return ResponseHandler.error("Error al cargar las categorías", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id){
        try {

            CategoryDTO categoryDTO = serviceCategory.getCategoryById(id);
            if(categoryDTO == null){
                return ResponseHandler.error("No existe una categoría con el id " +id, HttpStatus.NOT_FOUND);
            }
            return ResponseHandler.success("Categoría obtenida con éxito", categoryDTO);

        } catch (Exception e) {
            logger.error("Error con la categoría con id " +id, e);
            return ResponseHandler.error("Error al cargar la categoría con ese id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        try {

            CategoryDTO categoryDTO = serviceCategory.addCategory(category);
            return ResponseHandler.success("Categoría guardada con éxito", categoryDTO);

        } catch (Exception e) {
            logger.error("Error al guardar la categoría con id " + category.getId(), e);
            return ResponseHandler.error("Error al guardar la categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable int id){
        try {
            CategoryDTO categoryDTO = serviceCategory.updateCategory(category,id);
            return ResponseHandler.success("Categoría actualizada con éxito", categoryDTO);
        } catch (Exception e) {
            logger.error("Error con el id" +id, e);
            return ResponseHandler.error("Error al actualizar la categoría", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id){
        try {
            CategoryDTO categoryToDelete = serviceCategory.getCategoryById(id);
            serviceCategory.deleteCategory(id);
            return ResponseHandler.success("Categoría eliminada con éxito", categoryToDelete);

        } catch (Exception e) {
            logger.error("Error al eliminar la categoría con id " +id, e);
            return ResponseHandler.error("Error al eliminar la categoría" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
