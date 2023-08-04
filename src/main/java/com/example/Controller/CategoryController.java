package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.CategoryService;
import com.example.payload.CategoryDto;
import com.example.payload.ProductDto;
@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		
		CategoryDto createProducts=categoryService.createCategory(categoryDto);
		
		return new ResponseEntity(createProducts,HttpStatus.CREATED);
	}
		
	
	
		@GetMapping("/viewAllCategory")
		public ResponseEntity<List<CategoryDto>> viewCategory(){
			List<CategoryDto> viewAll = categoryService.viewCategory();
			return new ResponseEntity(viewAll,HttpStatus.ACCEPTED);
		
		}
			
			@GetMapping("/view/{id}")
			public ResponseEntity<Optional<CategoryDto>> viewCategoryById(@PathVariable(value = "id") int categoryId){
				
				Optional<CategoryDto> view=	categoryService.viewCategoryById(categoryId);
				return new ResponseEntity(view,HttpStatus.OK);
			}
			
			@DeleteMapping("/del/{id}")
			
			public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") int productid) {
				categoryService.CategoryDto(productid);
				return new ResponseEntity<String>("Deleted Product SucessFully",HttpStatus.ACCEPTED);
			}
			
			
    @PutMapping("/update/{id}")

			public CategoryDto updateCategory(@PathVariable(value = "id") int categoryId,@RequestBody CategoryDto newp) {
        	   
        	 CategoryDto updateProduct = categoryService.updateCategory(categoryId, newp);
        	   
				return updateProduct;
				
				
			}
}
