package com.example.food.controller;

import com.example.food.exception.ApiResponce;
import com.example.food.payload.MenuItemDto;
import com.example.food.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    // add MenuItem 
    @PostMapping("/menuItem")
    private ResponseEntity<MenuItemDto> createMenuItem(@RequestBody MenuItemDto MenuItemDto) {
        MenuItemDto createdMenuItem = this.menuItemService.createMenuItem(MenuItemDto);
        return new ResponseEntity<MenuItemDto>(createdMenuItem, HttpStatus.CREATED);
    }

    // Fetch MenuItem record by MenuItemById
    @GetMapping("/MenuItem/{MenuItemId}")
    ResponseEntity<MenuItemDto> createHostel(@PathVariable int MenuItemId) {
        MenuItemDto recivedMenuItem = this.menuItemService.getMenuItemById(MenuItemId);
        return new ResponseEntity<MenuItemDto>(recivedMenuItem, HttpStatus.OK);
    }

    //Fetch all MenuItem record by AllMenuItems
    @GetMapping("/MenuItem")
    ResponseEntity<List<MenuItemDto>> createMenuItem() {
        List<MenuItemDto> recivedAllMenuItems = this.menuItemService.getAllMenuItem();
        return new ResponseEntity<List<MenuItemDto>>(recivedAllMenuItems, HttpStatus.OK);
    }

    // update MenuItem record MenuItemById
    @PutMapping("/MenuItem/{MenuItemId}")
    ResponseEntity<MenuItemDto> updateMenuItemById(@RequestBody MenuItemDto MenuItemDto, @PathVariable int MenuItemId) {
        MenuItemDto updatedMenuItem = this.menuItemService.updateMenuItemById(MenuItemDto, MenuItemId);
        return new ResponseEntity<MenuItemDto>(updatedMenuItem, HttpStatus.OK);
    }

    //delete MenuItem record by MenuItemId
    @DeleteMapping("/MenuItem/{MenuItemId}")
    ResponseEntity<ApiResponce>deleteMenuItem(@PathVariable int MenuItemId)
    {
        this.menuItemService.deleteMenuItemById(MenuItemId);
        ApiResponce responce = new ApiResponce();
        responce.setMessage("MenuItem deleted succesfully");
        responce.setSucess(true);
        return new ResponseEntity<ApiResponce>(responce,HttpStatus.OK);
    }
}