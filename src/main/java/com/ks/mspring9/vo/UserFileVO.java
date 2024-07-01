package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserFileVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "imgType can not null")
    private String imgType;

    @NotNull(message = "fileName can not null")
    private String fileName;

    @NotNull(message = "path can not null")
    private String path;

    @NotNull(message = "profileImg can not null")
    private Integer profileImg;

    @NotNull(message = "uploadDate can not null")
    private String uploadDate;

    @NotNull(message = "thumb can not null")
    private byte[] thumb;

}
