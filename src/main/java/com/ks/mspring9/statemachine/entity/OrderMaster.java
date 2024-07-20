package com.ks.mspring9.statemachine.entity;

import lombok.Data;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "order_master")
public class OrderMaster implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "order_master_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderMasterId;

    @Column(name="status", nullable= false)
    private Boolean status;
}
