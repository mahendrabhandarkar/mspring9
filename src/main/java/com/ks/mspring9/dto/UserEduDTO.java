package com.ks.mspring9.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserEduDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer userId;

    private Integer eduLevelId;

    private Integer eduFieldId;

    private Integer workWithId;

    private Integer workAsId;

    private Integer annualIncome;

}
