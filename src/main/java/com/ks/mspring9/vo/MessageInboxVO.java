package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class MessageInboxVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "fromTo can not null")
    private Integer fromTo;

    @NotNull(message = "date can not null")
    private String date;

    @NotNull(message = "view can not null")
    private Integer view;

    @NotNull(message = "message can not null")
    private String message;

}
