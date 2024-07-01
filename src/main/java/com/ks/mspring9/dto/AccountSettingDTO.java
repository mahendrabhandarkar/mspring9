package com.ks.mspring9.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class AccountSettingDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer userId;

    private Integer displayMobile;

    private Integer displayEmail;

    private Integer displayProfile;

}
