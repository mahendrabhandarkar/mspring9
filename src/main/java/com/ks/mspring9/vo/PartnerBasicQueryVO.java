package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class PartnerBasicQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private Integer pcountryId;

    private Integer pstateId;

    private Integer pcityId;

    private Integer pmtongueId;

    private String pmaritalStatus;

    private Integer page;

    private Integer pageto;

    private Integer pheightto;

    private Integer pheight;

    private String pskinTone;

    private String pbodyType;

    private String pdisability;

    private String phivPositive;

    private Integer pprofileComplete;

}
