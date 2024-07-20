package com.ks.mspring9.statemachine.entity;

import lombok.Data;

import java.io.Serializable;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "stt_queue_node_master")
public class SttQueueNodeMaster implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "node_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nodeId;

    @Column(name = "node_name", nullable = false)
    private String nodeName;

    @Column(name = "node_short_code", nullable = false)
    private String nodeShortCode;

    @Column(name="status", nullable= false)
    private Boolean status;
}
