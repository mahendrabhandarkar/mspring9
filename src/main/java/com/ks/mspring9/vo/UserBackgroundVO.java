package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserBackgroundVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "religionId can not null")
    private Integer religionId;

    @NotNull(message = "communityId can not null")
    private Integer communityId;

    @NotNull(message = "subCommunity can not null")
    private String subCommunity;

    @NotNull(message = "bcomplete can not null")
    private Integer bcomplete;

}
