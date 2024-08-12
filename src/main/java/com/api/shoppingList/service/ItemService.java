package com.api.shoppingList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.shoppingList.entities.ItemEntity;
import com.api.shoppingList.exeptions.ItemNotFoundException;
import com.api.shoppingList.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	//Constructor
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	// method to create a new item
	public ItemEntity createItem(String name) {
		// validate item name
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Item name cannot be empty");
		}

		// create a new item and save to the repository
		ItemEntity item = new ItemEntity(name);
		return itemRepository.save(item);
	}

	// Method to find all saved items
	public List<ItemEntity> getAllItems() {
		return itemRepository.findAll();
	}

	// Method to update saved items
	public ItemEntity updateItem(long id, String newName) {
		// checks if the item exists
		ItemEntity item = itemRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("Item not found with ID: " + id));

		// update de name item
		item.setItem(newName);
		return itemRepository.save(item);
	}

	// Method to item delete
	public void deleteItem(long id) {
		// checks if the item exists
		if (!itemRepository.existsById(id)) {
			throw new ItemNotFoundException("Item not found with ID: " + id);
		}

		// delete the desired item
		itemRepository.deleteById(id);
	}

	// Method to search a item by id
	public ItemEntity getItemById(long id) {
		// checks if the item exists
		return itemRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("Item not found with ID: " + id));
	}
}
