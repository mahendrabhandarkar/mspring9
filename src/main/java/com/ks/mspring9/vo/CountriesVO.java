package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
@Data
public class CountriesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "sortname can not null")
    private String sortname;

    @NotNull(message = "name can not null")
    private String name;

}
