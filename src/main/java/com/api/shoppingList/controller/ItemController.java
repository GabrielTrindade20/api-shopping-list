package com.api.shoppingList.controller;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.shoppingList.entities.ItemEntity;
import com.api.shoppingList.repository.ItemRepository;



@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
//	public ItemController(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}
//	
	@GetMapping("/getItems")
	public List<ItemEntity> getAllItems() {
		return itemRepository.findAll();
	}
	
	@PostMapping("/registerItem")
    public ResponseEntity<ItemEntity> createItem(@RequestBody ItemEntity item) {
        ItemEntity savedItem = itemRepository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }
	
}
