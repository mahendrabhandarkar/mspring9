package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CitiesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer stateId;

}
