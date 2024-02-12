package com.project.marketlist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Produto")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Nome", length = 50)
    private String name;

    @Column(name = "Id_categoria")
    private Integer categoryId;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCategoryID() {
        return categoryId;
    }
}
