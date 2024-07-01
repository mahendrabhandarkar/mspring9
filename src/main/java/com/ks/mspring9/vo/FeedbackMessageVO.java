package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class FeedbackMessageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "email can not null")
    private String email;

    @NotNull(message = "subject can not null")
    private String subject;

    @NotNull(message = "message can not null")
    private String message;

}
