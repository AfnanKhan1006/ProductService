package com.afnan.productservice.controller;

import com.afnan.productservice.dtos.FakeStoreProductDto;
import com.afnan.productservice.dtos.GenericProductDto;
import com.afnan.productservice.models.Product;
import com.afnan.productservice.services.FakeStoreProductService;
import com.afnan.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDto> getProducts(){
        return productService.getProduct();
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductByID(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductsById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProductById(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProductById(id,product);
    }
}
