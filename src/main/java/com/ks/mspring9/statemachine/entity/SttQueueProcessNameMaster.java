package com.ks.mspring9.statemachine.entity;

import lombok.Data;

import java.io.Serializable;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "stt_queue_process_name_master")
public class SttQueueProcessNameMaster implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "process_queue_name_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer processQueueNameId;

    @Column(name = "process_name", nullable = false)
    private String queueEventName;

    @Column(name = "process_short_code", nullable = false)
    private Integer queueEventDescription;

    @Column(name="status", nullable= false)
    private Boolean status;
}
