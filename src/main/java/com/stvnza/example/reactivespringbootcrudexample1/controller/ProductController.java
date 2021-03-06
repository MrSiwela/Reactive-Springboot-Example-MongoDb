package com.stvnza.example.reactivespringbootcrudexample1.controller;

import com.stvnza.example.reactivespringbootcrudexample1.dto.ProductDto;
import com.stvnza.example.reactivespringbootcrudexample1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<ProductDto> products(){
        return  productService.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> product(@PathVariable(name = "id") String id){
        return productService.getProduct(id);
    }

    @GetMapping("/product-range")
    public Flux<ProductDto> productInRange(@RequestParam("min") double min,@RequestParam("max") double max){
        return productService.getProductInRange(min,max);
    }

    @PostMapping
    public Mono<ProductDto> saveProduct(Mono<ProductDto> product){
        return productService.saveProduct(product);
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@PathVariable("id") String id,Mono<ProductDto> product){
        return productService.updateProduct(product,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable("id") String id){
        return productService.deleteProduct(id);
    }
}
