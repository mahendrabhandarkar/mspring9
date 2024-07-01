package com.ks.mspring9.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class MessageInboxDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer userId;

    private Integer fromTo;

    private String date;

    private Integer view;

    private String message;

}
