package com.neosoft.springbootCurdOperation.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class Address {

    private String district;
    private String city;
    private String state;

}
