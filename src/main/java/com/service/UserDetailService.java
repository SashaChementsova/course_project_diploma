package com.service;

import com.dto.UserDto;
import com.model.UserDetail;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserDetailService {

    public void saveUser(UserDto userDto, String roleName) throws IOException;
    public void saveUser(UserDetail userDetail, String roleName) throws IOException;
    public UserDetail updateUser(UserDetail user);

    public List<UserDto> getUsers();
    public UserDetail findUserById(int id);

    public void deleteUser(int id);

    public UserDetail findUserByEmail(String email) ;

    public UserDetail findUserByPhone(String phone) ;
    public int calculateAge(String dateOfBirth);
}
