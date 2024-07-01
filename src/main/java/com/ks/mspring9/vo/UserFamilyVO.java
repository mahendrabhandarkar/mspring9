package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserFamilyVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "fatherName can not null")
    private String fatherName;

    @NotNull(message = "motherName can not null")
    private String motherName;

    @NotNull(message = "fatherStatus can not null")
    private String fatherStatus;

    @NotNull(message = "motherStatus can not null")
    private String motherStatus;

    @NotNull(message = "familyStatus can not null")
    private String familyStatus;

    @NotNull(message = "brother can not null")
    private Integer brother;

    @NotNull(message = "sister can not null")
    private Integer sister;

}
