package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class CiSessionsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "sessionId can not null")
    private String sessionId;

    @NotNull(message = "ipAddress can not null")
    private String ipAddress;

    @NotNull(message = "userAgent can not null")
    private String userAgent;

    @NotNull(message = "lastActivity can not null")
    private Long lastActivity;

    @NotNull(message = "userData can not null")
    private String userData;

}
