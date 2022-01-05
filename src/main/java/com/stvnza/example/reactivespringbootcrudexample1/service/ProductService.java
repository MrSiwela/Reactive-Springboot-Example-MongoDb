package com.stvnza.example.reactivespringbootcrudexample1.service;

import com.stvnza.example.reactivespringbootcrudexample1.dto.ProductDto;
import com.stvnza.example.reactivespringbootcrudexample1.entity.Product;
import com.stvnza.example.reactivespringbootcrudexample1.repository.ProductRepository;
import com.stvnza.example.reactivespringbootcrudexample1.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Flux<ProductDto> getProducts(){
        return productRepository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<ProductDto> getProduct(String id){
        return productRepository.findById(id).map(AppUtils::entityToDto);
    }

}
