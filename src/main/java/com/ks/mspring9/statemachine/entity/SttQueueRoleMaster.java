package com.ks.mspring9.statemachine.entity;

import lombok.Data;

import java.io.Serializable;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "stt_queue_role_master")
public class SttQueueRoleMaster implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "role_short_code", nullable = false)
    private String roleShortCode;

    @Column(name="status", nullable= false)
    private Boolean status;
}
