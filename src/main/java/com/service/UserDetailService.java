package com.service;

import com.dto.UserDto;
import com.model.UserDetail;

import java.util.List;

public interface UserDetailService {

    public void saveUser(UserDetail userDetails, String roleName);
    public UserDetail updateUser(UserDetail user);

    public List<UserDto> getUsers();
    public UserDetail findUserById(int id);

    public void deleteUser(int id);

    public UserDetail findUserByEmail(String email) ;
    public int calculateAge(String dateOfBirth);
}
