package com.uploadexcelfile.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    @NotEmpty
    @Size(min = 4,message = "Username must be min of 4 character !!")
    private String name;
    @Email(message = "Email address is not valid !!")
    private String email;
    @NotNull
    @Size(min = 3,max = 10,message = "password must be 3-10 character !!")
    private String password;
    @NotNull
    private String about;

    private Set<RoleDto> roles = new HashSet<>();
}
