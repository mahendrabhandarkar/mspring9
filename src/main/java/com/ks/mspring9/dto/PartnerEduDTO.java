package com.ks.mspring9.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class PartnerEduDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer userId;

    private Integer peduLevelId;

    private Integer peduFieldId;

    private Integer pworkWithId;

    private Integer pworkAsId;

    private Integer pannualIncome;

}
