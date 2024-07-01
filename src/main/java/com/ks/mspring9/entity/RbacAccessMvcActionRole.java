package com.ks.mspring9.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "rbac_access_mvc_action_role")
public class RbacAccessMvcActionRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long actionRoleId;

    @Column
    private RbacAccessMvcAccessType rbacAccessMvcAccessType;

    @Column
    private RbacAccessMvcAction rbacAccessMvcAction;

    @Column
    private RbacAccessRole rbacAccessRole;

}
