package com.ks.mspring9.statemachine.entity;

import lombok.Data;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "stt_queue_node_process_master")
public class SttQueueNodeProcessMaster implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "node_process_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nodeProcessId;

//    @Column(name="node_id", nullable=false)
//    private Integer nodeId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "node_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueNodeMaster sttQueueNodeMaster;

    @Column(name="role_process_id", nullable=false)
    private Integer roleProcessId;

    @Column(name="status", nullable= false)
    private Boolean status;

    @Column(name="start_flag", nullable= false)
    private Boolean startFlag;

    @Column(name="end_flag", nullable= false)
    private Boolean endFlag;
}
