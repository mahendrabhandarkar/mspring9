package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CiSessionsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sessionId;

    private String ipAddress;

    private String userAgent;

    private Long lastActivity;

    private String userData;

}
