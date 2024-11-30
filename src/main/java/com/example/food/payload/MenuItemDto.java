package com.example.food.payload;

import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuItemDto {
    private Long id;


    private String name;


    private String category; // e.g., "Breakfast", "Lunch", "Drinks"


    private String description;


    private Double price;

    private String imageUrl; // Stores the image URL or file path
}

