package com.example.food.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tb_menu") // Maps the entity to the "tb_menu" table in the database
public class MenuItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the primary key
    private Long id;


    @Column(nullable = false) // Ensures this field cannot be null
    private String name;

    @Column(nullable = false)
    private String category; // e.g., "Breakfast", "Lunch", "Drinks"

    @Column(length = 500) // Allows up to 500 characters
    private String description;

    @Column(nullable = false)
    private Double price;

    private String imageUrl; // Stores the image URL or file path
}
