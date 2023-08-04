package com.example.Service;

import java.util.List;
import java.util.Optional;

import com.example.payload.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);
	
	List<CategoryDto> viewCategory();
	
	Optional<CategoryDto> viewCategoryById(int categoryId);
	
	void CategoryDto(int categoryId);
	
	CategoryDto updateCategory(int categoryId,CategoryDto newp);

	


	
}
