package com.ks.mspring9.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserFileDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer userId;

    private String imgType;

    private String fileName;

    private String path;

    private Integer profileImg;

    private String uploadDate;

    private byte[] thumb;

}
