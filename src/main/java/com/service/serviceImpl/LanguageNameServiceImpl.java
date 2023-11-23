package com.service.serviceImpl;

import com.model.LanguageName;
import com.repository.LanguageNameRepository;
import com.service.LanguageNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageNameServiceImpl implements LanguageNameService {
    private final LanguageNameRepository languageNameRepository;
    @Autowired
    public LanguageNameServiceImpl(LanguageNameRepository languageNameRepository){
        this.languageNameRepository = languageNameRepository;
    }
    @Override
    public LanguageName addAndUpdateLanguageName(LanguageName languageName){
        return languageNameRepository.save(languageName);
    }
    @Override
    public List<LanguageName> getLanguageNames(){
        return languageNameRepository.findAll();
    }
    @Override
    public LanguageName findLanguageNameById(int id){

        return languageNameRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteLanguageName(int id){
        languageNameRepository.deleteById(id);
    }
}
