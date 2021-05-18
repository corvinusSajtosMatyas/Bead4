package com.sajtos.bead4.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String username;
    private String first_name;
    private String last_name;
    private String password;
}
