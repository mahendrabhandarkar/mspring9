package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class HeightQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String heightCode;

    private String globalHeight;

}
