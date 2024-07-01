package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_album")
public class UserAlbum implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "album_name", nullable = false)
    private String albumName;

    @Column(name = "album_folder", nullable = false)
    private String albumFolder;

    @Column(name = "album_create_date", nullable = false)
    private LocalDateTime albumCreateDate;

}
