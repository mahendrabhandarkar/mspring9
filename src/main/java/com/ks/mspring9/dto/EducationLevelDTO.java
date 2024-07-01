package com.ks.mspring9.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class EducationLevelDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String eduLevel;

}
