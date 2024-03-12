package com.xxj.zykczhsx43.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

//    private static final long serialVersionUID = 1L;
}