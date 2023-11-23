package com.service.serviceImpl;

import com.model.Interview;
import com.repository.InterviewRepository;
import com.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterviewServiceImpl implements InterviewService {
    private final InterviewRepository interviewRepository;
    @Autowired
    public InterviewServiceImpl(InterviewRepository interviewRepository){
        this.interviewRepository = interviewRepository;
    }
    @Override
    public Interview addAndUpdateInterview(Interview interview){
        return interviewRepository.save(interview);
    }
    @Override
    public List<Interview> getInterviews(){
        return interviewRepository.findAll();
    }
    @Override
    public Interview findInterviewById(int id){

        return interviewRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteInterview(int id){
        interviewRepository.deleteById(id);
    }
}
