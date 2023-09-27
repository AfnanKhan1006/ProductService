package com.afnan.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Categorys")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Category extends BaseModel{
    private String name;
}
