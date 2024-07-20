package com.ks.mspring9.statemachine.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "stt_queue_node_event")
public class SttQueueNodeEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "node_event_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nodeEventId;

    @Column(name = "queue_event_name", nullable = false)
    private String queueEventName;

    @Column(name = "queue_event_description", nullable = false)
    private String queueEventDescription;
}
