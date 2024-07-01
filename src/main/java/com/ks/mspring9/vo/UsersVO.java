package com.ks.mspring9.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class UsersVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "username can not null")
    private String username;

    @NotNull(message = "password can not null")
    private String password;

    @NotNull(message = "email can not null")
    private String email;

    @NotNull(message = "mobileNo can not null")
    private String mobileNo;

    @NotNull(message = "profileFor can not null")
    private String profileFor;

    @NotNull(message = "gender can not null")
    private String gender;

    @NotNull(message = "dob can not null")
    private String dob;

    @NotNull(message = "activated can not null")
    private Boolean activated;

    @NotNull(message = "banned can not null")
    private Boolean banned;

    private String banReason;

    private String newPasswordKey;

    private LocalDateTime newPasswordRequested;

    private String newEmail;

    private String newEmailKey;

    @NotNull(message = "lastIp can not null")
    private String lastIp;

    @NotNull(message = "lastLogin can not null")
    private LocalDateTime lastLogin;

    @NotNull(message = "created can not null")
    private LocalDateTime created;

    @NotNull(message = "modified can not null")
    private LocalDateTime modified;

    @NotNull(message = "firstname can not null")
    @NotBlank(message = "Firstname should not be blank")
    private String firstname;

    @NotNull(message = "lastname can not null")
    private String lastname;

}
