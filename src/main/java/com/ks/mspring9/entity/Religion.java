package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "religion")
public class Religion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "religion_name", nullable = false)
    private String religionName;

    // mapped with property name in entity of community
    @OneToMany(mappedBy = "religionId")
    private Set<Community> communities;
}
