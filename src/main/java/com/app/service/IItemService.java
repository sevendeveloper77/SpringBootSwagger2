package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface IItemService {
	
	public Integer saveItem(Item i);
	public List<Item> getAllItems();
	public Item getOneItem(Integer id);
	public void deleteItem(Integer id);
	public Item updateItem(Item i);
}
