package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

public Product getById(int product);

}
