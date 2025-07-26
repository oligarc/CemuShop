package com.oligarc.online_shop.restController;

import com.oligarc.online_shop.model.ProductVariant;
import com.oligarc.online_shop.service.ServiceProductVariant;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProductVariant> getAllProducts(){
        return serviceProductVariant.getAllProductVariants();
    }
}
