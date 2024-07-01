package com.ks.mspring9.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class PartnerBackgroundDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer userId;

    private Integer preligionId;

    private Integer pcommunityId;

    private String psubCommunity;

}
