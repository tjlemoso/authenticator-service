package org.acme.com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTOResponse {

    private int userId;

    private String name;

    private String password;

    private Boolean isAdmin;

}
