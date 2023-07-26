package com.example.pp_3_1_2_springboot.service;


import com.example.pp_3_1_2_springboot.dto.UserDto;

import java.util.List;

public interface UserService {
    void add(UserDto userDto);
    List<UserDto> getListOfUsers();

    UserDto findById(Long id);

    void deleteById(Long id);

    void merge(UserDto userDto);
}
