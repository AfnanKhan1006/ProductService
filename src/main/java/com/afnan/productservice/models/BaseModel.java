package com.afnan.productservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BaseModels")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
