package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Category;
import com.example.Model.Product;


@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{

	Category save(Optional<Category> oldp);


}
