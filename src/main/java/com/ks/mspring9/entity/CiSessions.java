package com.ks.mspring9.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ci_sessions")
public class CiSessions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "session_id", nullable = false)
    private String sessionId;

    @Column(name = "ip_address", nullable = false)
    private String ipAddress;

    @Column(name = "user_agent", nullable = false)
    private String userAgent;

    @Column(name = "last_activity", nullable = false)
    private Long lastActivity;

    @Column(name = "user_data", nullable = false)
    private String userData;

}
