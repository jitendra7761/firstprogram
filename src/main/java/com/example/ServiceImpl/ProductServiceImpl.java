package com.example.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFoundException;
import com.example.Model.Product;
import com.example.Repository.CategoryRepo;
import com.example.Repository.ProductRepo;
import com.example.Service.ProductService;
import com.example.payload.ProductDto;
import com.example.Model.Category;

import com.example.payload.CategoryDto;
@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepo  productRepo ;
	@Autowired
	private CategoryRepo categoryRepo ;
	
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public ProductDto createProduct(ProductDto productDto, int catId) {

	   /* Category cat = this.categoryRepo.findById(catId)
	            .orElseThrow(() -> new ResourceNotFoundException("Category does not exist", String.valueOf(catId)));

	   // Product product = modelMapper.map(productDto, Product.class);
	    
	    Product product=toEntity(productDto);
	    product.setCategory(cat);

	    Product savedProduct = productRepo.save(product);

	    //ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);
	    ProductDto dto= toDto(savedProduct);
	  //  savedProductDto.setCategory(catDto);

	    return dto;
	}
*/
		//Fetch Catgory where we want to add Product
		Category cat = this.categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("This Category id not found Catgory"));
		
		//ProductDto to Product
		System.out.println(productDto.getProduct_name());
		Product product = toEntity(productDto);
		//System.out.println("ProductDto to Product"+product.getProductName());
		product.setCategory(cat);
		
		//Save Product into Database
		Product save= this.productRepo.save(product);
				 
		 // Change Product to ProductDto
		 ProductDto dto = toDto(save);
		 	return dto;
	}


	@Override
	public List<ProductDto> viewProduct() {
		List<Product> list=productRepo.findAll();
		List<ProductDto> allEmp=list.stream().map(user->modelMapper.map(user,ProductDto.class)).collect(Collectors.toList());
		return allEmp;
	}


	@Override
	public Optional<ProductDto> viewProductById(int productid)throws ResourceNotFoundException {

		Product employee =productRepo.findById(productid)
				  .orElseThrow(() -> new ResourceNotFoundException("Employee Does not exits",productid));
		
		ProductDto userDto = this.modelMapper.map(employee, ProductDto.class);
		return Optional.ofNullable(userDto);
		
	}


	@Override
	public void ProductDto(int productid) throws ResourceNotFoundException{
		Product	 em =productRepo.findById(productid).
				orElseThrow(()->new ResourceNotFoundException("Employee Does not exits",productid));
		productRepo.delete(em);
	}


	@Override
	public ProductDto updateProduct(int producid, ProductDto newp) {
		Product oldp=productRepo.getById(producid);
		oldp.setProduct_imageName(newp.getProduct_imageName());
		oldp.setProduct_name(newp.getProduct_name());
		oldp.setProduct_prize(newp.getProduct_prize());
		oldp.setProduct_quantity(newp.getProduct_quantity());
		oldp.setStock(newp.isStock()); 
		oldp.setLive(newp.isLive());
		oldp.setProduct_desc(newp.getProduct_desc());
		Product saved=productRepo.save(oldp);
		ProductDto savedEmp=modelMapper.map(saved, ProductDto.class);
		return savedEmp;
		
	}
	
	

	//ProductDto to Product
	public Product toEntity(ProductDto pDto){
		//Product p=new Product();
//		p.setProductId(pDto.getProductId());
//		p.setProductName(pDto.getProductName());
//		p.setProductDesc(pDto.getProductDesc());
//		p.setProductPrize(pDto.getProductPrize());
//		p.setImageName(pDto.getImageName());
//		p.setLive(pDto.isLive());
//		p.setStock(pDto.isStock());
		return this.modelMapper.map(pDto, Product.class);
	}
	
	//Product to productDto
	public ProductDto toDto(Product product) {
		ProductDto pDto=new ProductDto();
		pDto.setProduct_id(product.getProduct_id());
		pDto.setProduct_imageName(product.getProduct_imageName());
		pDto.setProduct_name(product.getProduct_name());
		pDto.setProduct_desc(product.getProduct_desc());
		pDto.setProduct_prize(product.getProduct_prize());
		pDto.setLive(product.isLive());
		pDto.setStock(product.isStock());
		
		//Change Category to CategotyDto
	    	CategoryDto catDto=new CategoryDto();
		catDto.setCategoryId(product.getCategory().getCategoryId());
		catDto.setTitle(product.getCategory().getTitle());
		
		//Then Set Category Dto in Product Dto
		    pDto.setCategory(catDto);
		return pDto;
	}

	}
	
	
	
	

