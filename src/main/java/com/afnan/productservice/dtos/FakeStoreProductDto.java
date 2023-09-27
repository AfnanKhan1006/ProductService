package com.afnan.productservice.dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String category;
    private String description;
    private String image;
    private double price;
}
