package com.ks.mspring9.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserHobbiesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Integer id;

    @NotNull(message = "userId can not null")
    private Integer userId;

    @NotNull(message = "hobbies can not null")
    private String hobbies;

    @NotNull(message = "interests can not null")
    private String interests;

    @NotNull(message = "favMusic can not null")
    private String favMusic;

    @NotNull(message = "favBooks can not null")
    private String favBooks;

    @NotNull(message = "preMovies can not null")
    private String preMovies;

    @NotNull(message = "cookFood can not null")
    private String cookFood;

    @NotNull(message = "ownWords can not null")
    private String ownWords;

}
