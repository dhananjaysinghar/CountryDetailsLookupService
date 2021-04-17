package com.identity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class States {

    @Id
    @Column(length = 11)
    @JsonIgnore
    private int id;
    @Column(length = 30)
    private String name;

    @OneToMany(targetEntity = Cities.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private Set<Cities> cities;
}