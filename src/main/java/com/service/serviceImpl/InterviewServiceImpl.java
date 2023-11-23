package com.service.serviceImpl;

import com.model.InterviewEntity;
import com.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterviewServiceImpl {
    private final InterviewRepository interviewRepository;
    @Autowired
    public InterviewServiceImpl(InterviewRepository interviewRepository){
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
