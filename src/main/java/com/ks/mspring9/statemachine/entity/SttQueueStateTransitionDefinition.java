package com.ks.mspring9.statemachine.entity;
import lombok.Data;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "stt_queue_state_transition_definition")
public class SttQueueStateTransitionDefinition implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "queue_state_definition_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer queueStateDefinitionId;

//    @Column(name="queue_state_transition_id", nullable=false)
//    private Integer queueStateTransitionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "queue_state_transition_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueStateTransitionMaster sttQueueStateTransitionMaster;

//    @Column(name="role_rank_user_id", nullable=false)
//    private Integer roleRankUserId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_rank_user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueRoleRankUser sttQueueRoleRankUser;

    @Column(name = "rank_short_code", nullable = false)
    private String rankShortCode;

//    @Column(name="order_master_id", nullable=false)
//    private Integer orderMasterId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_master_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OrderMaster orderMaster;
}
