package com.dbzCharacters.demo.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table
public class Character {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(length = 50)
    @NotNull
    private String name;

    @Column(length = 50)
    @NotNull
    private String race;

    @Column
    private Integer ki;

    @Column(length = 50)
    private String speciality;

    @Column(length = 50)
    private String maxLevel;

}
