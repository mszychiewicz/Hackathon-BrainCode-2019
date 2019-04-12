package com.braincode.backend.alfa;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
class Alfa {
    private @Id
    @GeneratedValue
    Long id;

    private String name;

    /*@JsonBackReference()
    @OneToMany(mappedBy = "alfa")
    private List<Beta> betas;*/
}
