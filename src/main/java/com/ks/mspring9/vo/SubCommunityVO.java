package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class SubCommunityVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "communityId can not null")
    private Integer communityId;

    @NotNull(message = "subCommunityName can not null")
    private String subCommunityName;

}
