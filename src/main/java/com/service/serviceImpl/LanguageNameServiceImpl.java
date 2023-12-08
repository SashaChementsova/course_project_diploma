package com.service.serviceImpl;

import com.comparators.LanguageNameComparator;
import com.model.*;
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
        List<LanguageName> languageNames=languageNameRepository.findAll();
        languageNames.sort(new LanguageNameComparator());
        return languageNames;
    }
    @Override
    public LanguageName findLanguageNameById(int id){

        return languageNameRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteLanguageName(int id){
        languageNameRepository.deleteById(id);
    }

    @Override
    public void initializeLanguageName(){
        try{
            languageNameRepository.save(new LanguageName("Английский"));
        }
        catch (Exception ex){
            System.out.println("Значения уже есть");
        }


    }

    @Override
    public boolean checkLevelLanguageByEmployees(LanguageName languageName){
        List<Language> languages=languageName.getLanguageEntities();
        if(languages!=null){
            if(!(languages.isEmpty())){
                for(Language language:languages){
                    List<Employee> employees=language.getEmployeeEntities();
                    if(employees!=null){
                        if(!(employees.isEmpty())){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean checkLevelLanguageByVacancies(LanguageName languageName){
        List<Language> languages=languageName.getLanguageEntities();
        if(languages!=null){
            if(!(languages.isEmpty())){
                for(Language language:languages){
                    List<Vacancy> vacancies=language.getVacancyEntities();
                    if(vacancies!=null){
                        if(!(vacancies.isEmpty())){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean checkLevelLanguageByCandidate(LanguageName languageName){
        List<Language> languages=languageName.getLanguageEntities();
        if(languages!=null){
            if(!(languages.isEmpty())){
                for(Language language:languages){
                    List<Candidate> candidates=language.getCandidateEntities();
                    if(candidates!=null){
                        if(!(candidates.isEmpty())){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean checkLevelLanguageByTestQuestions(LanguageName languageName){
        List<Language> languages=languageName.getLanguageEntities();
        if(languages!=null){
            if(!(languages.isEmpty())){
                for(Language language:languages){
                    List<LanguageTestQuestion> languageTestQuestions=language.getLanguageTestQuestionEntities();
                    if(languageTestQuestions!=null){
                        if(!(languageTestQuestions.isEmpty())){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
