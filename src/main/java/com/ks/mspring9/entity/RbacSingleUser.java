package com.ks.mspring9.entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RbacSingleUser implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private Integer userId;

    @Column
    private String password;

    @Column
    private Integer loginSession;

    @Column
    private RbacAccessUser rbacAccessUser;

}
