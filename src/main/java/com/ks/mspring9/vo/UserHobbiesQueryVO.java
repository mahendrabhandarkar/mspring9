package com.ks.mspring9.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserHobbiesQueryVO implements Serializable {
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
