package com.afnan.productservice.services;

import com.afnan.productservice.dtos.FakeStoreProductDto;
import com.afnan.productservice.dtos.GenericProductDto;
import com.afnan.productservice.models.Category;
import com.afnan.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductUrl = "https://fakestoreapi.com/products";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private GenericProductDto fakeStoreProductToGenericProductConversion(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();

        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());

        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =  restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return fakeStoreProductToGenericProductConversion(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto createProduct(Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(genericProductUrl,product, GenericProductDto.class);
        return response.getBody();
    }

    @Override
    public List<GenericProductDto> getProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =  restTemplate.getForEntity(genericProductUrl, FakeStoreProductDto[].class);
        List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : Arrays.stream(response.getBody()).toList()){
            genericProductDtoList.add(fakeStoreProductToGenericProductConversion(fakeStoreProductDto));
        }
        return genericProductDtoList;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response =  restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return fakeStoreProductToGenericProductConversion(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto updateProductById(Long id, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(GenericProductDto.class);
        ResponseExtractor<ResponseEntity<GenericProductDto>> responseExtractor = restTemplate.responseEntityExtractor(GenericProductDto.class);
        ResponseEntity<GenericProductDto> response = restTemplate.execute(specificProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, id, product);
        return response.getBody();
    }
}
