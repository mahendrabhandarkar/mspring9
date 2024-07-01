package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class PartnerBasicVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "pcountryId can not null")
    private Integer pcountryId;

    @NotNull(message = "pstateId can not null")
    private Integer pstateId;

    @NotNull(message = "pcityId can not null")
    private Integer pcityId;

    @NotNull(message = "pmtongueId can not null")
    private Integer pmtongueId;

    @NotNull(message = "pmaritalStatus can not null")
    private String pmaritalStatus;

    @NotNull(message = "page can not null")
    private Integer page;

    @NotNull(message = "pageto can not null")
    private Integer pageto;

    @NotNull(message = "pheightto can not null")
    private Integer pheightto;

    @NotNull(message = "pheight can not null")
    private Integer pheight;

    @NotNull(message = "pskinTone can not null")
    private String pskinTone;

    @NotNull(message = "pbodyType can not null")
    private String pbodyType;

    @NotNull(message = "pdisability can not null")
    private String pdisability;

    @NotNull(message = "phivPositive can not null")
    private String phivPositive;

    @NotNull(message = "pprofileComplete can not null")
    private Integer pprofileComplete;

}
