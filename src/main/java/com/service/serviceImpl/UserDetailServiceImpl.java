package com.service.serviceImpl;

import com.dto.UserDto;
import com.model.RoleEntity;
import com.model.UserDetailsEntity;
import com.repository.RoleRepository;
import com.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl {
    private final UserDetailsRepository userDetailsRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailServiceImpl(UserDetailsRepository userDetailsRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userDetailsRepository=userDetailsRepository;
        this.roleRepository=roleRepository;
        this.passwordEncoder=passwordEncoder;
    }


    public void saveUser(UserDetailsEntity userDetails, String roleName){
//        UserDetailsEntity user = new UserDetailsEntity();
//        user.setEmail(userDto.getEmail());
//        // encrypt the password using spring security
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setName(userDto.getName());
//        user.setPatronymic(userDto.getPatronymic());
//        user.setSurname(userDto.getSurname());
//        user.setPhone(userDto.getPhone());
//        user.setEmail(userDto.getEmail());
//        user.setInfo(userDto.getInfo());
        RoleEntity role = roleRepository.findByNameRole(roleName);
        if(role == null){
            role = checkRoleExist(roleName);
        }
        userDetails.setRoles(Arrays.asList(role));
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        userDetailsRepository.save(userDetails);
    }

    public UserDetailsEntity updateUser(UserDetailsEntity user){
        return userDetailsRepository.save(user);
    }

    public List<UserDto> getUsers(){
        List<UserDetailsEntity> users = userDetailsRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    public UserDetailsEntity findUserById(int id){

        return userDetailsRepository.findById(id).orElse(null);
    }

    public void deleteUser(int id){
        userDetailsRepository.deleteById(id);
    }

    private UserDto mapToUserDto(UserDetailsEntity user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private RoleEntity checkRoleExist(String roleName){
        RoleEntity role = new RoleEntity();
        role.setNameRole(roleName);
        return roleRepository.save(role);
    }


    public UserDetailsEntity findUserByEmail(String email) {
        return userDetailsRepository.findByEmail(email);
    }
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
