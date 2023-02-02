package org.fi.allcompleterestboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.fi.allcompleterestboot.dto.CategoryDTO;


import org.fi.allcompleterestboot.entity.Category;

import org.fi.allcompleterestboot.repositories.CategoryRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository repositoryCategory;

	@Override
	public CategoryDTO getCategoryById(CategoryDTO cid) {
		// TODO Auto-generated method stub
		Category ecid = new Category();
		BeanUtils.copyProperties(cid, ecid);

		Optional<Category> optEntity = repositoryCategory.findById(ecid);
		if (optEntity.isPresent()) {
			// Product entity = optEntity.get();
			Category entity = optEntity.get();
			// ProductDTO dto = new ProductDTO();
			CategoryDTO dto = new CategoryDTO();
			// ProductIdDTO dtoId = new ProductIdDTO();

			BeanUtils.copyProperties(entity.getCategoryId(), dto);
			BeanUtils.copyProperties(entity, dto);
			dto.setCategoryId(0);
			return dto;
		}
		return null;
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> dataList = repositoryCategory.findAll();

		ArrayList<CategoryDTO> list = new ArrayList<>();

		for (Category entity : dataList) {

			CategoryDTO dto = new CategoryDTO();
			//ProductIdDTO dtoId = new ProductIdDTO();

			BeanUtils.copyProperties(entity.getCategoryId(), dto);
			BeanUtils.copyProperties(entity, dto);
			//dto.setId(dtoId);
			list.add(dto);

		}
		return list;
	}

	@Override
	public boolean addNewCategory(CategoryDTO objCategory) {
		// TODO Auto-generated method stub
		return false;
	}

}
