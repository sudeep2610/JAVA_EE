package org.fi.allcompleterestboot.controllers;

import java.util.List;

import org.fi.allcompleterestboot.dto.ProductDTO;
import org.fi.allcompleterestboot.dto.ProductIdDTO;
import org.fi.allcompleterestboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public ProductDTO getProduct(@RequestBody ProductIdDTO pid)
	{
		return productService.getProductById(pid);
	}
	
	@GetMapping("/all")
	public List<ProductDTO> gatAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@PostMapping("/addProduct")
	public boolean addNewProduct(@RequestBody ProductDTO objProduct)
	{
		return productService.addNewProduct(objProduct);
	}
}
