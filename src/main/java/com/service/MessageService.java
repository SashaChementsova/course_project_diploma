package com.service;

import com.model.MessageEntity;
import com.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageService {
    private final MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public MessageEntity addAndUpdateMessage(MessageEntity messageEntity){
        return messageRepository.save(messageEntity);
    }
    public List<MessageEntity> getMessages(){
        return messageRepository.findAll();
    }

    public MessageEntity findMessageById(int id){

        return messageRepository.findById(id).orElse(null);
    }
    public void deleteMessage(int id){
        messageRepository.deleteById(id);
    }
}
