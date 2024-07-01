package com.ks.mspring9.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserProfilesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    private String website;

    @NotNull(message = "motherTongueId can not null")
    private Integer motherTongueId;

    @NotNull(message = "religionId can not null")
    private Integer religionId;

    @NotNull(message = "countryId can not null")
    private Integer countryId;

    @NotNull(message = "stateId can not null")
    private Integer stateId;

    @NotNull(message = "cityId can not null")
    private Integer cityId;

    @NotNull(message = "maritalStatus can not null")
    private String maritalStatus;

    @NotNull(message = "height can not null")
    private String height;

    @NotNull(message = "skinTone can not null")
    private String skinTone;

    @NotNull(message = "bodyType can not null")
    private String bodyType;

    @NotNull(message = "diet can not null")
    private String diet;

    @NotNull(message = "smoke can not null")
    private String smoke;

    @NotNull(message = "drink can not null")
    private String drink;

    @NotNull(message = "ownWords can not null")
    private String ownWords;

    @NotNull(message = "disability can not null")
    private String disability;

    @NotNull(message = "hivPositive can not null")
    private String hivPositive;

    @NotNull(message = "profileComplete can not null")
    private Integer profileComplete;

}
