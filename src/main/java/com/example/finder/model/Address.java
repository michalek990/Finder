package com.example.finder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "houseNumber")
    private String houseNumber;

    @Column(name = "zipCode")
    private String zipCode;

//    @ManyToOne
//    @JoinColumn(name = "city_id")
//    private City city;
}
