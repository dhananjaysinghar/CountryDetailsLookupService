package com.identity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Countries {

    @Id
    @Column(length = 11)
    @JsonIgnore
    private int id;
    @Column(length = 150)
    private String name;
    @Column(length = 11)
    @JsonProperty("phoneCode")
    private Integer phonecode;
    @Column(length = 3)
    @JsonProperty("countryCode")
    private String sortname;

    @OneToMany(targetEntity = States.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Set<States> states;
}