package com.example.food.serviceImplimentation;

import com.example.food.entity.MenuItemEntity;
import com.example.food.exception.ResourceNotFoundException;
import com.example.food.payload.MenuItemDto;
import com.example.food.repository.MenuItemRepository;
import com.example.food.service.MenuItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImplimentation implements MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public MenuItemDto createMenuItem(MenuItemDto menuItemDto) {
        // TODO Auto-generated method stub
        MenuItemEntity MenuItemEntity = this.modelMapper.map(menuItemDto,MenuItemEntity.class);
        MenuItemEntity saveMenuItem = this.menuItemRepository.save(MenuItemEntity);
        return this.modelMapper.map(saveMenuItem,MenuItemDto.class);
    }

    @Override
    public MenuItemDto getMenuItemById(long menuItemId) {
        // TODO Auto-generated method stub
        MenuItemEntity menuItem = this.menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem", "MenuItemId",menuItemId));
        return this.modelMapper.map(menuItem,MenuItemDto.class);
    }

    @Override
    public List<MenuItemDto> getAllMenuItem() {
        List<MenuItemDto> getAllMenuItems = this.menuItemRepository.findAll().stream()
                .map(menuItem -> this.modelMapper.map(menuItem,MenuItemDto.class)).collect(Collectors.toList());
        return getAllMenuItems;
    }

    @Override
    public MenuItemDto updateMenuItemById(MenuItemDto menuItemDto, long menuItemId) {
        MenuItemEntity menuItemEntity = this.menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem", "MenuItemId", menuItemId));
        MenuItemEntity updatedMenuItemEntity = this.modelMapper.map(menuItemDto, MenuItemEntity.class);

        MenuItemEntity saveMenuItem = this.menuItemRepository.save(updatedMenuItemEntity);

        return this.modelMapper.map(saveMenuItem,MenuItemDto.class);

    }

    @Override
    public void deleteMenuItemById(long menuItemId) {
        MenuItemEntity MenuItemEntity = this.menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem", "MenuItemId", menuItemId));
        this.menuItemRepository.delete(MenuItemEntity);
 
    }
    public MenuItemEntity MenuItemDtoToMenuItemEntity(MenuItemDto MenuItemDto) {
        return this.modelMapper.map(MenuItemDto, MenuItemEntity.class);
    }

    public MenuItemDto MenuItemEntityToMenuItemDto(MenuItemEntity MenuItemEntity) {
        return this.modelMapper.map(MenuItemEntity, MenuItemDto.class);
    }

}
