package com.ks.mspring9.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserLifestyleUpdateVO extends UserLifestyleVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
