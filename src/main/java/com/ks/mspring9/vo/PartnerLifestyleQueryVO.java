package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class PartnerLifestyleQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private String pdiet;

    private String psmoke;

    private String pdrink;

}
