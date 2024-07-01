package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;


@Data
public class PartnerEduVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "peduLevelId can not null")
    private Integer peduLevelId;

    @NotNull(message = "peduFieldId can not null")
    private Integer peduFieldId;

    @NotNull(message = "pworkWithId can not null")
    private Integer pworkWithId;

    @NotNull(message = "pworkAsId can not null")
    private Integer pworkAsId;

    @NotNull(message = "pannualIncome can not null")
    private Integer pannualIncome;

}
