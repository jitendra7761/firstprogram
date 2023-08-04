package com.example.Service;

import java.util.List;
import java.util.Optional;

import com.example.payload.ProductDto;

public interface ProductService {
	
	ProductDto createProduct(ProductDto productDto, int catId);
	
	
	//ProductDto createProduct(ProductDto productDto,int catId);
	List<ProductDto> viewProduct();
	
	//List<ProductDto> viewProduct(int productId);
	
	Optional<ProductDto> viewProductById(int productid);
	
	void ProductDto(int productid);
	
	ProductDto updateProduct(int producid,ProductDto newp);

}
