package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_hobbies")
public class UserHobbies implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "hobbies", nullable = false)
    private String hobbies;

    @Column(name = "interests", nullable = false)
    private String interests;

    @Column(name = "fav_music", nullable = false)
    private String favMusic;

    @Column(name = "fav_books", nullable = false)
    private String favBooks;

    @Column(name = "pre_movies", nullable = false)
    private String preMovies;

    @Column(name = "cook_food", nullable = false)
    private String cookFood;

    @Column(name = "own_words", nullable = false)
    private String ownWords;

}
