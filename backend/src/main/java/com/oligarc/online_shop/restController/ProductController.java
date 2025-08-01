package com.oligarc.online_shop.restController;


import com.oligarc.online_shop.DTO.ProductDTO;
import com.oligarc.online_shop.handler.ResponseHandler;
import com.oligarc.online_shop.model.Product;
import com.oligarc.online_shop.service.ServiceProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ServiceProduct serviceProduct;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ServiceProduct v_serviceProduct) {
        this.serviceProduct = v_serviceProduct;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        try {
            List<ProductDTO> products = serviceProduct.getAllProducts();

            if (products.isEmpty()) {
                return ResponseHandler.error("No existen datos", HttpStatus.NOT_FOUND);
            }

            return ResponseHandler.success("Productos cargados con éxito", products);
        } catch (Exception e) {
            logger.error("Problema al cargar los productos", e);
            return ResponseHandler.error("Hubo un error al cargar los productos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {

        try {
            ProductDTO product = serviceProduct.getProductById(id);
            if (product == null) {
                return ResponseHandler.error("Problema con el id " + id, HttpStatus.NOT_FOUND);
            }

            return ResponseHandler.success("Producto obtenido con éxito", product);

        } catch (Exception e) {
            logger.error("Error al obtener el producto con id: " + id, e);
            return ResponseHandler.error("Error al obtener el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/name")
    public ResponseEntity<?> getProductsByName(@RequestParam String name){

        try {

            List<ProductDTO> products = serviceProduct.getProductsByName(name);
            if(products.isEmpty()){
                return ResponseHandler.error("No existen datos", HttpStatus.NOT_FOUND);
            }

            return ResponseHandler.success("Productos cargados con éxito", products);

        }catch (Exception e){
            logger.error("Error al obtener producto con nombre " +name , e);
            return ResponseHandler.error("Error al obtener productos con ese nombre", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    /*


    @PostMapping("/")
    public ResponseEntity<?> addProduct(@RequestBody Product product){

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable int id){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){

    }

    */


}
