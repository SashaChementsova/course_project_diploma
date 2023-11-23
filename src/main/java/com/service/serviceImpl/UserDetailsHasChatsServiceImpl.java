package com.service.serviceImpl;

import com.model.UserDetailsHasChats;
import com.repository.UserDetailsHasChatsRepository;
import com.service.UserDetailsHasChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserDetailsHasChatsServiceImpl implements UserDetailsHasChatService {
    private final UserDetailsHasChatsRepository userDetailsHasChatsRepository;
    @Autowired
    public UserDetailsHasChatsServiceImpl(UserDetailsHasChatsRepository userDetailsHasChatsRepository){
        this.userDetailsHasChatsRepository = userDetailsHasChatsRepository;
    }
    @Override
    public UserDetailsHasChats addAndUpdateUserDetailsHasChat(UserDetailsHasChats userDetailsHasChats){
        return userDetailsHasChatsRepository.save(userDetailsHasChats);
    }
    @Override
    public List<UserDetailsHasChats> getUserDetailsHasChats(){
        return userDetailsHasChatsRepository.findAll();
    }

    @Override
    public UserDetailsHasChats findUserDetailsHasChatById(int id){

        return userDetailsHasChatsRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteUserDetailsHasChat(int id){
        userDetailsHasChatsRepository.deleteById(id);
    }
}
