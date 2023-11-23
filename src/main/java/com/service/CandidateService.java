package com.service;

import com.model.CandidateEntity;
import com.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    @Autowired
    public CandidateService(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }

    public CandidateEntity addAndUpdateCandidate(CandidateEntity candidateEntity){
        return candidateRepository.save(candidateEntity);
    }
    public List<CandidateEntity> getCandidates(){
        return candidateRepository.findAll();
    }

    public CandidateEntity findCandidateById(int id){

        return candidateRepository.findById(id).orElse(null);
    }
    public void deleteCandidate(int id){
        candidateRepository.deleteById(id);
    }
}
