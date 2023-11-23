package com.service.serviceImpl;

import com.model.Language;
import com.repository.LanguageRepository;
import com.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
    @Override
    public Language addAndUpdateLanguage(Language language){
        return languageRepository.save(language);
    }
    @Override
    public List<Language> getLanguages(){
        return languageRepository.findAll();
    }
    @Override
    public Language findLanguageById(int id){
        return languageRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteLanguage(int id){
        languageRepository.deleteById(id);
    }
}
