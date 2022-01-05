package com.stvnza.example.reactivespringbootcrudexample1.repository;

import com.stvnza.example.reactivespringbootcrudexample1.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
}
