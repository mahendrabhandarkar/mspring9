package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_lifestyle")
public class UserLifestyle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "diet", nullable = false)
    private String diet;

    @Column(name = "smoke", nullable = false)
    private String smoke;

    @Column(name = "drink", nullable = false)
    private String drink;

}
