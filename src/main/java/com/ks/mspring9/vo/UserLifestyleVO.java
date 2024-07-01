package com.ks.mspring9.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserLifestyleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "diet can not null")
    private String diet;

    @NotNull(message = "smoke can not null")
    private String smoke;

    @NotNull(message = "drink can not null")
    private String drink;

}
