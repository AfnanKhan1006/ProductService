package com.afnan.productservice.services;

import com.afnan.productservice.dtos.FakeStoreProductDto;
import com.afnan.productservice.dtos.GenericProductDto;
import com.afnan.productservice.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {
    public GenericProductDto getProductById(Long id);
    public GenericProductDto createProduct(Product product);
    public List<GenericProductDto> getProduct();
    public GenericProductDto deleteProductById(Long id);
    public GenericProductDto updateProductById(Long id,Product product);
}
