package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class MotherTongueVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "mtongue can not null")
    private String mtongue;

}
