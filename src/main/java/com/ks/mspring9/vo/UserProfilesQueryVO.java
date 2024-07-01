package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserProfilesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private String website;

    private Integer motherTongueId;

    private Integer religionId;

    private Integer countryId;

    private Integer stateId;

    private Integer cityId;

    private String maritalStatus;

    private String height;

    private String skinTone;

    private String bodyType;

    private String diet;

    private String smoke;

    private String drink;

    private String ownWords;

    private String disability;

    private String hivPositive;

    private Integer profileComplete;

}
