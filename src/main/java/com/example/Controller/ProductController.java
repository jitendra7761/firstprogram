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

import com.example.payload.ProductDto;
import com.example.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/create/{catId}")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto,@PathVariable int catId) {
		
		/*ProductDto createProducts=productService.createProduct(productDto,catId);
		
		 System.out.println(" createProducts---------"+createProducts.getProduct_id());
		 System.out.println(" createProducts---------"+createProducts.getCategory());
		return new ResponseEntity(createProducts,HttpStatus.CREATED);*/
		//System.out.println(product.getProductName());
		 ProductDto createProduct = productService.createProduct(productDto,catId);
		return new ResponseEntity<ProductDto>(createProduct,HttpStatus.CREATED);
	}
	
	
		@GetMapping("/viewAllProduct")
	 	public ResponseEntity<List<ProductDto>> viewProduct(){
			List<ProductDto> viewAll = productService.viewProduct();
			return new ResponseEntity(viewAll,HttpStatus.ACCEPTED);
		
		}
		
		
		
		/*  @GetMapping("/product/{productId}")
		    public ResponseEntity<List<ProductDto>> getProduct(@PathVariable int productId) {
		        List<ProductDto> product = productService.viewProduct(productId);
		        
		        if (product != null) {
		            String category = ((ProductDto) product).getCategory();
		            // Do something with the category value
		            return ResponseEntity.ok(product);
		        } else {
		            return ResponseEntity.notFound().build();
		        }
		    }
		*/
		
			
			@GetMapping("/view/{id}")
			public ResponseEntity<Optional<ProductDto>> viewProductById(@PathVariable(value = "id") int productid){
				
				Optional<ProductDto> view=	productService.viewProductById(productid);
				return new ResponseEntity(view,HttpStatus.OK);
			}
			
			@DeleteMapping("/del/{id}")
			
			public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") int productid) {
				productService.ProductDto(productid);
				return new ResponseEntity<String>("Deleted Product SucessFully",HttpStatus.ACCEPTED);
			}
			
			
           @PutMapping("/update/{id}")

			public ProductDto updateProduct(@PathVariable(value = "id") int productid,@RequestBody ProductDto newp) {
        	   
        	 ProductDto updateProduct = productService.updateProduct(productid, newp);
        	   
				return updateProduct;
				
				
			}
			
}

