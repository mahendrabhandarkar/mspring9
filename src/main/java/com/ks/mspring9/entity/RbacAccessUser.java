package com.ks.mspring9.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "rbac_access_user")
public class RbacAccessUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private String name;
    @Column
    private String userType;
    @Column
    private Integer userId;
    @Column
    private boolean status;
//    @Column
//    private Set<RbacAccessRole> roles = new HashSet<>();

}
