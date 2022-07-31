package com.uploadexcelfile.services;


import com.uploadexcelfile.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUser();
    void deleteUser(Integer userId);

    UserDto registerNewUser(UserDto userDto);
}
