package com.ks.mspring9.statemachine.entity;
import lombok.Data;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

import com.ks.mspring9.entity.User;

@Data
@Entity
@Table(name = "stt_queue_role_rank_user")
public class SttQueueRoleRankUser implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "role_rank_user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleRankUserId;

//    @Column(name="role_rank_id", nullable=false)
//    private Integer roleRankId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_rank_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueRoleRank sttQueueRoleRank;

//    @Column(name="user_id", nullable=false)
//    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name="status", nullable= false)
    private Boolean status;
}
