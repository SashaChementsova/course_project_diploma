package com.service;

import com.model.InterviewEntity;
import com.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InterviewService {
    private final InterviewRepository interviewRepository;
    @Autowired
    public InterviewService(InterviewRepository interviewRepository){
        this.interviewRepository = interviewRepository;
    }

    public InterviewEntity addAndUpdateInterview(InterviewEntity interviewEntity){
        return interviewRepository.save(interviewEntity);
    }
    public List<InterviewEntity> getInterviews(){
        return interviewRepository.findAll();
    }

    public InterviewEntity findInterviewById(int id){

        return interviewRepository.findById(id).orElse(null);
    }
    public void deleteInterview(int id){
        interviewRepository.deleteById(id);
    }
}
