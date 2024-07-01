package com.ks.mspring9.entity.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserAutologinId implements Serializable {
    private String keyId;
    private Integer userId;

}
