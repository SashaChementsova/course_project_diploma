package com.service;

import com.model.SkillEntity;
import com.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SkillService {
    private final SkillRepository skillRepository;
    @Autowired
    public SkillService(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    public SkillEntity addAndUpdateSkill(SkillEntity skillEntity){
        return skillRepository.save(skillEntity);
    }
    public List<SkillEntity> getSkills(){
        return skillRepository.findAll();
    }

    public SkillEntity findSkillById(int id){

        return skillRepository.findById(id).orElse(null);
    }
    public void deleteSkill(int id){
        skillRepository.deleteById(id);
    }
}
