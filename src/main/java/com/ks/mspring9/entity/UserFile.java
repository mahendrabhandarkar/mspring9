package com.ks.mspring9.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "user_file")
public class UserFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "img_type", nullable = false)
    private String imgType;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "profile_img", nullable = false)
    private Integer profileImg;

    @Column(name = "upload_date", nullable = false)
    private String uploadDate;

    @Column(name = "thumb", nullable = false)
    private byte[] thumb;

}
