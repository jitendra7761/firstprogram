package com.example.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFoundException;
import com.example.Model.Category;
import com.example.Model.Product;
import com.example.Repository.CategoryRepo;
import com.example.Service.CategoryService;
import com.example.payload.CategoryDto;
import com.example.payload.ProductDto;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category emp = modelMapper.map(categoryDto,Category.class);
			
			Category saved =categoryRepo.save(emp);
			
			CategoryDto savedEmp=modelMapper.map(saved, CategoryDto.class);
			
			return savedEmp;
	}

	@Override
	public List<CategoryDto> viewCategory() {
		List<Category> list=categoryRepo.findAll();
		List<CategoryDto> allEmp=list.stream().map(user->modelMapper.map(user,CategoryDto.class)).collect(Collectors.toList());
		return allEmp;
	}

	@Override
	public Optional<CategoryDto> viewCategoryById(int categoryId) throws ResourceNotFoundException{
		Category employee =categoryRepo.findById(categoryId)
				  .orElseThrow(() -> new ResourceNotFoundException("Employee Does not exits",categoryId));
		
		CategoryDto userDto = this.modelMapper.map(employee, CategoryDto.class);
		return Optional.ofNullable(userDto);
		
	}

	@Override
	public void CategoryDto(int categoryId) {
		Category	 em =categoryRepo.findById(categoryId).
				orElseThrow(()->new ResourceNotFoundException("Employee Does not exits",categoryId));
		categoryRepo.delete(em);
		
	}

	@Override
	public CategoryDto updateCategory(int categoryId, CategoryDto newp) {
		Category oldp=categoryRepo.findById(categoryId).
				orElseThrow(()->new ResourceNotFoundException("Employee Does not exits",categoryId));
		
		oldp.setTitle(newp.getTitle());
		
		Category saved=categoryRepo.save(oldp);
		CategoryDto savedEmp=modelMapper.map(saved, CategoryDto.class);
		return savedEmp;
	}

	

}
