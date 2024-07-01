package com.ks.mspring9.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
@Data
public class UserSearchVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "gender can not null")
    private String gender;

    @NotNull(message = "profileImg can not null")
    private Integer profileImg;

    @NotNull(message = "maritalStatus can not null")
    private String maritalStatus;

    @NotNull(message = "religionId can not null")
    private Integer religionId;

    @NotNull(message = "motherTongueId can not null")
    private Integer motherTongueId;

    @NotNull(message = "countryId can not null")
    private Integer countryId;

    @NotNull(message = "stateId can not null")
    private Integer stateId;

    @NotNull(message = "cityId can not null")
    private Integer cityId;

    @NotNull(message = "eduId can not null")
    private Integer eduId;

    @NotNull(message = "diet can not null")
    private String diet;

    @NotNull(message = "disability can not null")
    private String disability;

    @NotNull(message = "hivPositive can not null")
    private String hivPositive;

}
