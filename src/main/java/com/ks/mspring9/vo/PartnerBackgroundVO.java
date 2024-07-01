package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class PartnerBackgroundVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "preligionId can not null")
    private Integer preligionId;

    @NotNull(message = "pcommunityId can not null")
    private Integer pcommunityId;

    @NotNull(message = "psubCommunity can not null")
    private String psubCommunity;

}
