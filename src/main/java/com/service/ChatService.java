package com.service;

import com.model.ChatEntity;
import com.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChatService {
    private final ChatRepository chatRepository;
    @Autowired
    public ChatService(ChatRepository chatRepository){
        this.chatRepository = chatRepository;
    }

    public ChatEntity addAndUpdateChat(ChatEntity chatEntity){
        return chatRepository.save(chatEntity);
    }
    public List<ChatEntity> getChats(){
        return chatRepository.findAll();
    }

    public ChatEntity findChatById(int id){

        return chatRepository.findById(id).orElse(null);
    }
    public void deleteChat(int id){
        chatRepository.deleteById(id);
    }
}
