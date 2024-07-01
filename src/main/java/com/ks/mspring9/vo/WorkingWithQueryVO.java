package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class WorkingWithQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String workWith;

}
