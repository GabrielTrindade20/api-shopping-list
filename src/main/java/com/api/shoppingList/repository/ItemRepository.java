package com.api.shoppingList.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shoppingList.entities.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
	  
}
