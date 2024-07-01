package com.ks.mspring9.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "rbac_access_mvc_action")
public class RbacAccessMvcAction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long actionId;

    @Column
    private String name;

    @Column
    private Boolean status;

    @Column
    private String url;

    @Column
    private Long fkModuleKsCndId;

}
