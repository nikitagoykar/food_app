package com.example.food.service;

import com.example.food.entity.MenuItemEntity;
import com.example.food.payload.MenuItemDto;

import java.util.List;

public interface MenuItemService {
    public MenuItemDto createMenuItem(MenuItemDto menuItemDto);

    public MenuItemDto getMenuItemById(long menuItemId);

    public List<MenuItemDto> getAllMenuItem();

    public MenuItemDto updateMenuItemById(MenuItemDto menuItemDto,long menuItemId);

    public void deleteMenuItemById(long menuItemId);
    public List<MenuItemDto> getMenuItemsByCategory(String category);
}
