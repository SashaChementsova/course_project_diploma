package com.service.serviceImpl;

import com.model.SkillEntity;
import com.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkillServiceImpl {
    private final SkillRepository skillRepository;
    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository){
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
