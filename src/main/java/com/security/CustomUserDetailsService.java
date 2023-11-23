package com.security;

import com.model.RoleEntity;
import com.model.UserDetailsEntity;
import com.repository.UserDetailsRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserDetailsRepository userDetailsRepository;

    public CustomUserDetailsService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetailsEntity user = userDetailsRepository.findByEmail(email);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }else{
            throw new UsernameNotFoundException("Неправильный(-ые) Email и/или пароль.");
        }
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <RoleEntity> roles) {
        Collection< ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getNameRole()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
