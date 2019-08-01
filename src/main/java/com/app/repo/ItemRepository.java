package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
