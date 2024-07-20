package com.ks.mspring9.statemachine.entity;
import lombok.Data;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "stt_queue_state_transition_master")
public class SttQueueStateTransitionMaster implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "queue_state_transition_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer queueStateTransitionId;

//    @Column(name="node_event_id", nullable=false)
//    private Integer nodeEventId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "node_event_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueNodeEvent sttQueueNodeEvent;

//    @Column(name="parent_node_process_id", nullable=false)
//    private Integer parentNodeProcessId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parent_node_process_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueNodeProcessMaster parentSttQueueNodeProcessMaster;

//    @Column(name="next_node_process_id", nullable=false)
//    private Integer nextNodeProcessId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "next_node_process_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueNodeProcessMaster nextSttQueueNodeProcessMaster;
}
