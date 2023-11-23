package com.service.serviceImpl;

import com.model.Candidate;
import com.repository.CandidateRepository;
import com.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;
    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }
    @Override
    public Candidate addAndUpdateCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }
    @Override
    public List<Candidate> getCandidates(){
        return candidateRepository.findAll();
    }
    @Override
    public Candidate findCandidateById(int id){

        return candidateRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteCandidate(int id){
        candidateRepository.deleteById(id);
    }
}
