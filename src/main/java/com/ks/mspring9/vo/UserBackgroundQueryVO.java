package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserBackgroundQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private Integer religionId;

    private Integer communityId;

    private String subCommunity;

    private Integer bcomplete;

}
