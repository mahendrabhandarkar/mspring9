package com.ks.mspring9.statemachine.entity;
import lombok.Data;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "stt_queue_role_rank")
public class SttQueueRoleRank implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "role_rank_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleRankId;

//    @Column(name="rank_id", nullable=false)
//    private Integer rankId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rank_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueRankMaster sttQueueRankMaster;

//    @Column(name="role_process_id", nullable=false)
//    private Integer processQueueNameId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_process_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueProcessNameMaster sttQueueProcessNameMaster;

    @Column(name = "rank_short_code", nullable = false)
    private String rankShortCode;

    @Column(name="status", nullable= false)
    private Boolean status;
}
