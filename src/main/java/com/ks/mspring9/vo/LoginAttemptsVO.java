package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class LoginAttemptsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "ipAddress can not null")
    private String ipAddress;

    @NotNull(message = "login can not null")
    private String login;

    @NotNull(message = "time can not null")
    private LocalDateTime time;

}
