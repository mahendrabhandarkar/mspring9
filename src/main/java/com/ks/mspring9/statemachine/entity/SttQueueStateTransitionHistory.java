package com.ks.mspring9.statemachine.entity;
import lombok.Data;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

import com.ks.mspring9.entity.User;

@Data
@Entity
@Table(name = "stt_queue_state_transition_history")
public class SttQueueStateTransitionHistory implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "queue_state_history_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer queueStateHistoryId;

//    @Column(name="node_event_id", nullable=false)
//    private Integer nodeEventId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "node_event_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueNodeEvent sttQueueNodeEvent;

    @Column(name = "remark", nullable = false)
    private String remark;

//    @Column(name="order_master_id", nullable=false)
//    private Integer orderMasterId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_master_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OrderMaster orderMaster;

    @Column(name = "action_event", nullable = false)
    private String actionEvent;

//    @Column(name="queue_state_transition_id", nullable=false)
//    private Integer queueStateTransitionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "queue_state_transition_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueStateTransitionDefinition sttQueueStateTransitionDefinition;

//    @Column(name="user_id", nullable=false)
//    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
