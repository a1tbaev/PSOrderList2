package com.example.psorderlist2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "subcategory")
@AllArgsConstructor
@NoArgsConstructor
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subcategory_seq")
    @SequenceGenerator(name = "subcategory_seq")
    private Long id;
    private String name;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Category category;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    private MenuItem menuItem;

    public Subcategory(String name) {
        this.name = name;
    }
}