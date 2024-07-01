package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class AccountSettingVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "displayMobile can not null")
    private Integer displayMobile;

    @NotNull(message = "displayEmail can not null")
    private Integer displayEmail;

    @NotNull(message = "displayProfile can not null")
    private Integer displayProfile;

}
