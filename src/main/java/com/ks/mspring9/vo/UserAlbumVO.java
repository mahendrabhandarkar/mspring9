package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserAlbumVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "albumName can not null")
    private String albumName;

    @NotNull(message = "albumFolder can not null")
    private String albumFolder;

    @NotNull(message = "albumCreateDate can not null")
    private LocalDateTime albumCreateDate;

}
