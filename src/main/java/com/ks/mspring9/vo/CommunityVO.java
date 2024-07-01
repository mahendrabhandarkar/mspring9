package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
@Data
public class CommunityVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "religionId can not null")
    private Integer religionId;

    @NotNull(message = "communityName can not null")
    private String communityName;

}
