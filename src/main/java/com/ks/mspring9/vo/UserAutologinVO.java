package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserAutologinVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "keyId can not null")
    private String keyId;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "userAgent can not null")
    private String userAgent;

    @NotNull(message = "lastIp can not null")
    private String lastIp;

    @NotNull(message = "lastLogin can not null")
    private LocalDateTime lastLogin;

}
