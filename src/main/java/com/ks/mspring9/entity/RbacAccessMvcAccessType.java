package com.ks.mspring9.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "rbac_access_mvc_access_type")
public class RbacAccessMvcAccessType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accessTypeId;

    @Column
    private String name;

    @Column
    private String httpMethod;

}
