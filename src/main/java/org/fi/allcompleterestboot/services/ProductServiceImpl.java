package org.fi.allcompleterestboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.fi.allcompleterestboot.dto.ProductDTO;
import org.fi.allcompleterestboot.dto.ProductIdDTO;
import org.fi.allcompleterestboot.entity.Product;
import org.fi.allcompleterestboot.entity.ProductId;
import org.fi.allcompleterestboot.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	MailService mailService;
	
	@Autowired
	ProductRepository repositoryProduct;
	
	@Override
	public ProductDTO getProductById(ProductIdDTO pid) {
		// TODO Auto-generated method stub
		
		ProductId epid = new ProductId();
		BeanUtils.copyProperties(pid, epid);
		
		Optional<Product> optEntity = repositoryProduct.findById(epid);
		if(optEntity.isPresent())
		{
			Product entity = optEntity.get();
			ProductDTO dto = new ProductDTO();
			ProductIdDTO dtoId = new ProductIdDTO();
			
			BeanUtils.copyProperties(entity.getId(), dtoId);
			BeanUtils.copyProperties(entity, dto);
			dto.setId(dtoId);
			return dto;
		}
		return null;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> dataList = repositoryProduct.findAll();
		
		ArrayList<ProductDTO> list = new ArrayList<>();
		
		for(Product entity : dataList)
		{
			
			ProductDTO dto = new ProductDTO();
			ProductIdDTO dtoId = new ProductIdDTO();
			
			BeanUtils.copyProperties(entity.getId(), dtoId);
			BeanUtils.copyProperties(entity, dto);
			dto.setId(dtoId);
			list.add(dto);
			
		}
		return list;
	}

	@Override
	public boolean addNewProduct(ProductDTO objProduct) {
		// TODO Auto-generated method stub
		
		ProductId pid = new ProductId();
		Product entity = new Product();
		
		BeanUtils.copyProperties(objProduct.getId(), pid);
		BeanUtils.copyProperties(objProduct, entity);
		entity.setId(pid);
		
		repositoryProduct.save(entity);
		
		String contents = "A new Product has been addes to the dataBase in product Table\n";
		
		contents += "Product Name : " + objProduct.getProductName();
		contents += "\nProduct Descr : " + objProduct.getProductDescription();
		contents += "\nProduct Price : " + objProduct.getProductPrice();
		contents += "\nProduct Image : " + objProduct.getProductImageUrl();
		contents += "\n----------------------------------------";
		
		mailService.sendMail("suryawanshisudeep97@gmail.com", "New Product Addes", contents);
		return true;
	}

}
