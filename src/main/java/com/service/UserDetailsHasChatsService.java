package com.service;

import com.model.UserDetailsHasChatsEntity;
import com.repository.UserDetailsHasChatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserDetailsHasChatsService {
    private final UserDetailsHasChatsRepository userDetailsHasChatsRepository;
    @Autowired
    public UserDetailsHasChatsService(UserDetailsHasChatsRepository userDetailsHasChatsRepository){
        this.userDetailsHasChatsRepository = userDetailsHasChatsRepository;
    }

    public UserDetailsHasChatsEntity addAndUpdateUserDetailsHasChat(UserDetailsHasChatsEntity userDetailsHasChatsEntity){
        return userDetailsHasChatsRepository.save(userDetailsHasChatsEntity);
    }
    public List<UserDetailsHasChatsEntity> getUserDetailsHasChats(){
        return userDetailsHasChatsRepository.findAll();
    }

    public UserDetailsHasChatsEntity findUserDetailsHasChatById(int id){

        return userDetailsHasChatsRepository.findById(id).orElse(null);
    }
    public void deleteUserDetailsHasChat(int id){
        userDetailsHasChatsRepository.deleteById(id);
    }
}
