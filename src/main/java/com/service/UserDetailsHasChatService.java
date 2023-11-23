package com.service;

import com.model.UserDetailsHasChats;

import java.util.List;

public interface UserDetailsHasChatService {
    public UserDetailsHasChats addAndUpdateUserDetailsHasChat(UserDetailsHasChats userDetailsHasChats);
    public List<UserDetailsHasChats> getUserDetailsHasChats();

    public UserDetailsHasChats findUserDetailsHasChatById(int id);
    public void deleteUserDetailsHasChat(int id);
}
