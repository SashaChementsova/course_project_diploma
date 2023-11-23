package com.service;

import com.model.Candidate;

import java.util.List;

public interface CandidateService {

    public Candidate addAndUpdateCandidate(Candidate candidate);
    public List<Candidate> getCandidates();

    public Candidate findCandidateById(int id);
    public void deleteCandidate(int id);
}
