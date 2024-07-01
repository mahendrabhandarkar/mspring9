package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserAutologinQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String keyId;

    private Integer userId;

    private String userAgent;

    private String lastIp;

    private LocalDateTime lastLogin;

}
