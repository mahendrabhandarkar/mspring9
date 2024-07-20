package com.ks.mspring9.statemachine.entity;
import lombok.Data;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "stt_queue_role_process")
public class SttQueueRoleProcess implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "role_process_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleProcessId;

//    @Column(name="role_id", nullable=false)
//    private Integer roleId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueRoleMaster sttQueueRoleMaster;

//    @Column(name="process_queue_name_id", nullable=false)
//    private Integer processQueueNameId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "process_queue_name_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SttQueueProcessNameMaster sttQueueProcessNameMaster;

    @Column(name="status", nullable= false)
    private Boolean status;

}
