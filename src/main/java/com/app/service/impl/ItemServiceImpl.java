package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Item;
import com.app.repo.ItemRepository;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	private ItemRepository repo;

	@Transactional
	public Integer saveItem(Item i) {
		return repo.save(i).getItemid();
	}

	@Transactional(readOnly = true)
	public List<Item> getAllItems() {
		List<Item> itemList=repo.findAll();
		if(itemList!=null && !itemList.isEmpty()) {
			itemList.stream()
			.sorted((i1,i2)->i1.getIcode().compareTo(i2.getIcode()));
		}
		return itemList;
	}

	@Transactional(readOnly = true)
	public Item getOneItem(Integer id) {
		Optional<Item> item=repo.findById(id);
		if(item.isPresent()) {
			item.get();
		}
		return null;
	}

	@Transactional
	public void deleteItem(Integer id) {
		repo.deleteById(id);
	}

	@Transactional
	public Item updateItem(Item i) {
		return repo.save(i);
	}
}
