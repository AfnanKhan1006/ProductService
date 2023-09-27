package com.afnan.productservice.dtos;

import com.afnan.productservice.models.Category;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class GenericProductDto {
    private Long id;
    private String title;
    private String category;
    private String description;
    private String image;
    private double price;
}
