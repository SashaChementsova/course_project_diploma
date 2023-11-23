package com.service.serviceImpl;

import com.model.ChatEntity;
import com.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChatServiceImpl {
    private final ChatRepository chatRepository;
    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository){
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
