package org.fi.allcompleterestboot.controllers;

import java.util.List;

import org.fi.allcompleterestboot.dto.CategoryDTO;

import org.fi.allcompleterestboot.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public CategoryDTO getCategory(@RequestBody CategoryDTO cid)
	{
		return categoryService.getCategoryById(cid);
	}
	
	@GetMapping("/all")
	public List<CategoryDTO> gatAllCategory()
	{
		return categoryService.getAllCategory();
	}
	
	@PostMapping("/addCategory")
	public boolean addNewCategory(@RequestBody CategoryDTO objCategory)
	{
		return categoryService.addNewCategory(objCategory);
	}
}
