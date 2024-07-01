package com.ks.mspring9.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserHobbiesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer userId;

    private String hobbies;

    private String interests;

    private String favMusic;

    private String favBooks;

    private String preMovies;

    private String cookFood;

    private String ownWords;

}
