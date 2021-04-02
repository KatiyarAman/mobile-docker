package com.mobiledocker.mobiledocker.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "country")
public class Country implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Set<State> states = new HashSet<State>(0);

    @Column(name = "deleted")
    private boolean deleted = false;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "mobilewarehouse")
    //private List<MobileWarehouse>  mobilewarehouse1 = new ArrayList<>();

    public Country() {
        this.deleted = false;
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, Set<State> states) {
        this.name = name;
        this.states = states;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 250)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    public Set<State> getStates() {
        return this.states;
    }

    public void setStates(Set<State> states) {
        this.states = states;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean isdeleted) {
        this.deleted = isdeleted;
    }


}
