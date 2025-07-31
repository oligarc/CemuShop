package com.oligarc.online_shop.service;

import com.oligarc.online_shop.DTO.CategoryDTO;
import com.oligarc.online_shop.model.Category;
import com.oligarc.online_shop.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class) //Needed for @Mock and @InjectMocks to work
public class ServiceCategoryImplTest {

    @Mock //Creates a false object, doesn't connect to the database
    private CategoryRepository categoryRepository; //Variable where we store the mock

    @InjectMocks //Tells Mockito to create an instance of serviceCategoryImpl and injects the mock categoryRepository
    private ServiceCategoryImpl serviceCategory;

    @Test //JUnit must execute
    void getAllCategories(){

        List<Category> categories = List.of( //To simulate data instead of bringing them from db
                new Category(1, "Acción"),
                new Category(2, "Aventura")
        );
        Mockito.when(categoryRepository.findAll()).thenReturn(categories); //We define the mock behaviour, when a client calls the method, it must return the simulated list
        List<CategoryDTO> result = serviceCategory.getAllCategories();

        assertEquals(2,result.size()); //Check if it has 2 elements like in the simulated list
        assertEquals("Acción", result.get(0).getName()); //Check the names
        assertEquals("Aventura", result.get(1).getName());
    }

    @Test
    void getCategoryById_returnsCategoryDTO_whenCategoryExists(){

        //Create a new test object that doesn't come from the database
        Category category = new Category();
        category.setId(1);
        category.setName("Calzones");

        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
        CategoryDTO result = serviceCategory.getCategoryById(1);

        assertEquals(1,result.getId());
        assertEquals("Calzones", result.getName());
    }

    @Test
    void getCategoryById_throwsException_whenCategoryNotFound(){
        Mockito.when(categoryRepository.findById(99)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class, () -> {
            serviceCategory.getCategoryById(99);
        });
    }
}
