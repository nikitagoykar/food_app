package com.example.food.repository;

import com.example.food.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MenuItemRepository extends JpaRepository<MenuItemEntity,Long>{
}
