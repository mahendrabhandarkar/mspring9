package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserEduVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "eduLevelId can not null")
    private Integer eduLevelId;

    @NotNull(message = "eduFieldId can not null")
    private Integer eduFieldId;

    @NotNull(message = "workWithId can not null")
    private Integer workWithId;

    @NotNull(message = "workAsId can not null")
    private Integer workAsId;

    @NotNull(message = "annualIncome can not null")
    private Integer annualIncome;

}
