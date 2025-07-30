package com.oligarc.online_shop.restController;

import com.oligarc.online_shop.DTO.ProductVariantDTO;
import com.oligarc.online_shop.handler.ResponseHandler;
import com.oligarc.online_shop.service.ServiceProductVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productVariant")
public class ProductVariantController {

    private ServiceProductVariant serviceProductVariant;

    @Autowired
    public ProductVariantController(ServiceProductVariant v_serviceProductVariant){
        this.serviceProductVariant=v_serviceProductVariant;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts(){
        try {
            List<ProductVariantDTO> products = serviceProductVariant.getAllProductVariants();
            if(products.isEmpty()){
                return ResponseHandler.error("No se encontraron productos", HttpStatus.NOT_FOUND);
            }

            return ResponseHandler.success("Productos cargados con éxito", products);
        } catch (Exception e) {
            return ResponseHandler.error("Hubo un fallo al cargar los productos", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
