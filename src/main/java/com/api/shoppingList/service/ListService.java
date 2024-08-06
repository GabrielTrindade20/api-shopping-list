package com.api.shoppingList.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.shoppingList.entities.ListEntity;
import com.api.shoppingList.repository.ItemRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ListService {

	private final ItemRepository listRepository;
	

	public ListService(ItemRepository listRepository) {
		this.listRepository = listRepository;
	}
	
	public List<ListEntity> getList(){
		return listRepository.findAll();
	}
}
