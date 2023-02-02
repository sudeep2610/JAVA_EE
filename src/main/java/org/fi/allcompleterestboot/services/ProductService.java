package org.fi.allcompleterestboot.services;

import java.util.List;

import org.fi.allcompleterestboot.dto.ProductDTO;
import org.fi.allcompleterestboot.dto.ProductIdDTO;

public interface ProductService {
	
	public ProductDTO getProductById(ProductIdDTO pid);
	
	public List<ProductDTO> getAllProducts();
	
	public boolean addNewProduct(ProductDTO objProduct);

}
