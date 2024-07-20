package com.ks.mspring9.statemachine.entity;
import lombok.Data;

import java.io.Serializable;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "stt_queue_rank_master")
public class SttQueueRankMaster implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rank_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rankId;

    @Column(name = "rank_name", nullable = false)
    private String rankName;

    @Column(name = "rank_short_code", nullable = false)
    private String rankShortCode;

    @Column(name="status", nullable= false)
    private Boolean status;
}
