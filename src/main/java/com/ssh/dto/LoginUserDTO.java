package com.ssh.dto;

import lombok.*;

/**
 * @Author lt
 * @create 2018-03-31 14:48
 * @VERSION 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO {

    private String username;
    private String password;
    private String token;

}
