package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class PartnerLifestyleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "pdiet can not null")
    private String pdiet;

    @NotNull(message = "psmoke can not null")
    private String psmoke;

    @NotNull(message = "pdrink can not null")
    private String pdrink;

}
