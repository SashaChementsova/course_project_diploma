package com.service.serviceImpl;

import com.dto.UserDto;
import com.model.Role;
import com.model.UserDetail;
import com.repository.RoleRepository;
import com.repository.UserDetailRepository;
import com.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailRepository userDetailRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userDetailRepository = userDetailRepository;
        this.roleRepository=roleRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public void saveUser(UserDetail userDetails, String roleName){
        Role role = roleRepository.findByNameRole(roleName);
        if(role == null){
            role = checkRoleExist(roleName);
        }
        userDetails.setRoles(Arrays.asList(role));
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        userDetailRepository.save(userDetails);
    }

    @Override
    public UserDetail updateUser(UserDetail user){
        return userDetailRepository.save(user);
    }

    @Override
    public List<UserDto> getUsers(){
        List<UserDetail> users = userDetailRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDetail findUserById(int id){

        return userDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(int id){
        userDetailRepository.deleteById(id);
    }

    private UserDto mapToUserDto(UserDetail user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist(String roleName){
        Role role = new Role();
        role.setNameRole(roleName);
        return roleRepository.save(role);
    }


    @Override
    public UserDetail findUserByEmail(String email) {
        return userDetailRepository.findByEmail(email);
    }
    @Override
    public int calculateAge(String dateOfBirth){
        int age=0;
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = null;
        Date dateTwo = null;
        try {
            dateOne = format.parse(date);
            dateTwo = format.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Количество дней между датами в миллисекундах
        long difference = dateOne.getTime() - dateTwo.getTime();
        // Перевод количества дней между датами из миллисекунд в дни
        double days = difference / (24 * 60 * 60 * 1000); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)
        double years=days/365;
        age= (int) Math.floor(years);
        return age;
    }
}
