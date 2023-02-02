package org.fi.allcompleterestboot.services;

import java.util.List;

import org.fi.allcompleterestboot.dto.CategoryDTO;

public interface CategoryService {

	public CategoryDTO getCategoryById(CategoryDTO cid);

	public List<CategoryDTO> getAllCategory();

	public boolean addNewCategory(CategoryDTO objCategory);

}
