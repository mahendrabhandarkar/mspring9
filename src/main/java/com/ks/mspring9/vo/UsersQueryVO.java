package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UsersQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private String email;

    private String mobileNo;

    private String profileFor;

    private String gender;

    private String dob;

    private Boolean activated;

    private Boolean banned;

    private String banReason;

    private String newPasswordKey;

    private LocalDateTime newPasswordRequested;

    private String newEmail;

    private String newEmailKey;

    private String lastIp;

    private LocalDateTime lastLogin;

    private LocalDateTime created;

    private LocalDateTime modified;

    private String firstname;

    private String lastname;

}
