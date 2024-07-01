package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class SendMessageQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private Integer sendTo;

    private String date;

    private Integer view;

    private String message;

}
