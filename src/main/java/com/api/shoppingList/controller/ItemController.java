package com.api.shoppingList.controller;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.shoppingList.ItemRequest.CreateItemRequest;
import com.api.shoppingList.ItemRequest.UpdateItemRequest;
import com.api.shoppingList.entities.ItemEntity;
import com.api.shoppingList.repository.ItemRepository;
import com.api.shoppingList.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemService itemService;

	// function to create an item
	@PostMapping("/create")
	public ResponseEntity<ItemEntity> createItem(@RequestBody String name) {
		ItemEntity createdItem = itemService.createItem(name);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
	}

	// function to get all item
	@GetMapping("/getAllItems")
	public ResponseEntity<List<ItemEntity>> getAllItems() {
		List<ItemEntity> items = itemService.getAllItems();
		return ResponseEntity.ok(items);
	}
	
	@GetMapping("/getItemById/{id}")
	public ResponseEntity<ItemEntity> getItemById(@PathVariable long id){
		ItemEntity idItem = itemService.getItemById(id);
		return ResponseEntity.ok(idItem);
	}

	//function to update an item
	@PutMapping("/update/{id}")
	public ResponseEntity<ItemEntity> updateItem(@PathVariable Long id, @RequestBody UpdateItemRequest request) {
		ItemEntity updateItem = itemService.updateItem(id, request.getName());
		return ResponseEntity.ok(updateItem);
	}

	//function to delete an item
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
		return ResponseEntity.noContent().build();
	}
	
}
