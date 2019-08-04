package com.dxb.agoodprovider.dto;

import lombok.Data;

/**
 * Created by dulei on 18/1/8.
 */
@Data
public class UserDTO {
    private Long id;
    private String name;
    private Integer age;

    private String username;
    private String password;
}
