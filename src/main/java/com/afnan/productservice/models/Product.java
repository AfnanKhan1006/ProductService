package com.afnan.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;
}
