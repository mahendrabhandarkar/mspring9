package com.ks.mspring9.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserFamilyDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer userId;

    private String fatherName;

    private String motherName;

    private String fatherStatus;

    private String motherStatus;

    private String familyStatus;

    private Integer brother;

    private Integer sister;

}
