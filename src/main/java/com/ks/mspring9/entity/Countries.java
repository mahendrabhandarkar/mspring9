package com.ks.mspring9.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "countries")
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sortname", nullable = false)
    private String sortname;

    @Column(name = "name", nullable = false)
    private String name;

}
