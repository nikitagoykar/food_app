package com.example.food.repository;

import com.example.food.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItemEntity,Long>{
    List<MenuItemEntity> findByCategory(String category); // Custom query to search by category
}
