package com.controller.hr;

import com.dto.LanguageNameList;
import com.dto.LevelLanguageList;
import com.dto.SkillList;
import com.model.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class HrVacancyController {
    private final VacancyService vacancyService;
    private final PositionNameService positionNameService;
    private final LevelPositionService levelPositionService;
    private final PositionService positionService;
    private final HrService hrService;
    private final CandidateService candidateService;
    private final BackgroundService backgroundService;
    private final LanguageService languageService;
    private final LanguageNameService languageNameService;
    private final LevelLanguageService levelLanguageService;
    private final CityCompanyService cityCompanyService;
    private final LanguageTestQuestionService languageTestQuestionService;
    private final PositionTestQuestionService positionTestQuestionService;

    private final UserDetailService userDetailService;
    @Autowired
    public HrVacancyController(UserDetailService userDetailService,LanguageTestQuestionService languageTestQuestionService,PositionTestQuestionService positionTestQuestionService,VacancyService vacancyService, PositionNameService positionNameService, LevelPositionService levelPositionService, PositionService positionService, HrService hrService, CandidateService candidateService,  BackgroundService backgroundService, LanguageService languageService, LanguageNameService languageNameService, LevelLanguageService levelLanguageService, CityCompanyService cityCompanyService) {
        this.vacancyService = vacancyService;
        this.positionNameService = positionNameService;
        this.levelPositionService = levelPositionService;
        this.positionService = positionService;
        this.hrService = hrService;
        this.candidateService = candidateService;
        this.languageTestQuestionService=languageTestQuestionService;
        this.positionTestQuestionService=positionTestQuestionService;
        this.backgroundService = backgroundService;
        this.languageService = languageService;
        this.languageNameService = languageNameService;
        this.levelLanguageService = levelLanguageService;
        this.cityCompanyService = cityCompanyService;
        this.userDetailService=userDetailService;
    }


    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @GetMapping("/hr/vacancies")
    public String getVacancies(PositionName positionName, LevelPosition levelPosition, Model model) {
        checkPositions();
        model.addAttribute("positionNames", positionNameService.getPositionNames());
        model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
        if (positionName.getIdPositionName()!=0 && levelPosition.getIdLevelPosition()!=0) {
            model.addAttribute("positionNameFind", positionName);
            model.addAttribute("levelPositionFind", levelPosition);
            Position position=new Position();
            position.setLevelPosition(levelPosition); position.setPositionName(positionName);
            position=positionService.addAndUpdatePosition(positionService.checkDuplicatePosition(position));
            model.addAttribute("vacancies", vacancyService.findVacanciesByPosition(position));
            if ( vacancyService.findVacanciesByPosition(position).isEmpty())
                model.addAttribute("emptiness", "empty");
        } else {
            model.addAttribute("positionNameFind", new PositionName());
            model.addAttribute("levelPositionFind", new LevelPosition());
            model.addAttribute("vacancies", vacancyService.getVacancies());
            if (vacancyService.getVacancies().isEmpty())
                model.addAttribute("emptiness", "empty");
        }
        return "hr/vacancyControl/getVacancies.html";
    }

    @GetMapping("/hr/vacancy/{id}")
    public String getVacancy(@PathVariable("id") String idVacancy, Model model) {
        checkPositions();
        model.addAttribute("vacancy",vacancyService.findVacancyById(Integer.parseInt(idVacancy)));
        model.addAttribute("hrs",hrService.getHrs());
        model.addAttribute("hrAdd",new Hr());
        model.addAttribute("positionNames", positionNameService.getPositionNames());
        model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
        model.addAttribute("positionNameFind", new PositionName());
        model.addAttribute("levelPositionFind", new LevelPosition());
        model.addAttribute("vacancies", vacancyService.getVacancies());
        return "hr/vacancyControl/getVacancy.html";
    }

    @GetMapping("/hr/vacancyHr/{idVacancy}/{idHr}")
    public String getVacancyHr(@PathVariable("idVacancy") String idVacancy,@PathVariable("idHr") String idHr, Model model) {
        checkPositions();
        model.addAttribute("hr",hrService.findHrById(Integer.parseInt(idHr)));
        model.addAttribute("vacancy",vacancyService.findVacancyById(Integer.parseInt(idVacancy)));
        return "hr/vacancyControl/getVacancyHr.html";
    }

    @GetMapping("/hr/vacancyHr/{idVacancy}/{idCandidate}")
    public String getVacancyCandidate(@PathVariable("idVacancy") String idVacancy,@PathVariable("idCandidate") String idCandidate, Model model) {
        checkPositions();
        model.addAttribute("candidate",candidateService.findCandidateById(Integer.parseInt(idCandidate)));
        model.addAttribute("vacancy",vacancyService.findVacancyById(Integer.parseInt(idVacancy)));
        return "hr/vacancyControl/getVacancyCandidate.html";
    }

    @GetMapping("/hr/vacancyAdd")
    public String addVacancy(Model model){
        model.addAttribute("vacancy",new Vacancy());
        model.addAttribute("positionName",new PositionName());
        model.addAttribute("levelPosition",new LevelPosition());
        model.addAttribute("positionNames", positionNameService.getPositionNames());
        model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
        model.addAttribute("languageNameAdd",new LanguageName());
        model.addAttribute("levelLanguageAdd",new LevelLanguage());
        model.addAttribute("languageNames", languageNameService.getLanguageNames());
        model.addAttribute("levelLanguages", levelLanguageService.getLevelLanguages());
        model.addAttribute("background",new Background());
        model.addAttribute("cityCompanies",cityCompanyService.getCityCompanies());
        model.addAttribute("cityCompany",new CityCompany());
        return "hr/vacancyControl/addVacancy.html";
    }
    @PostMapping("/hr/addVacancy/end")
    public String addVacancyEnd(Vacancy vacancy, PositionName positionName, LevelPosition levelPosition, LanguageName languageName, LevelLanguage levelLanguage, Background background, CityCompany cityCompany, Model model){
        model.addAttribute("vacancy",vacancy);
        model.addAttribute("positionName",positionName);
        model.addAttribute("levelPosition",levelPosition);
        model.addAttribute("positionNames", positionNameService.getPositionNames());
        model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
        model.addAttribute("languageNameAdd",languageName);
        model.addAttribute("levelLanguageAdd",levelLanguage);
        model.addAttribute("languageNames", languageNameService.getLanguageNames());
        model.addAttribute("levelLanguages", levelLanguageService.getLevelLanguages());
        model.addAttribute("background",background);
        model.addAttribute("cityCompanies",cityCompanyService.getCityCompanies());
        model.addAttribute("cityCompany",cityCompany);
        Position position=new Position();
        position.setPositionName(positionName);
        position.setLevelPosition(levelPosition);
        position=positionService.checkDuplicatePosition(position);
        positionService.addAndUpdatePosition(position);
        if(!(positionTestQuestionService.checkNumOfQuestionsByPosition(position,10))){
            model.addAttribute("failPositionQuestions","failPositionQuestions");
            return "hr/vacancyControl/addVacancy.html";
        }
        Language language=new Language();
        language.setLanguageName(languageName);
        language.setLevelLanguage(levelLanguage);
        language=languageService.checkDuplicateLanguage(language);
        languageService.addAndUpdateLanguage(language);
        if(!(languageTestQuestionService.checkNumOfQuestionsByLanguage(language,10))){
            model.addAttribute("failLanguageQuestions","failLanguageQuestions");
            return "hr/vacancyControl/addVacancy.html";
        }
        vacancy.setPosition(position);
        List<Language> languages=new ArrayList<>();languages.add(language);
        vacancy.setLanguages(languages);
        background=backgroundService.addAndUpdateBackground(background);
        vacancy.setBackground(background);
        vacancy.setCityCompany(cityCompanyService.findCityCompanyById(cityCompany.getIdCityCompany()));
        vacancy.setStatus(true);
        vacancy.setHr(hrService.findHrByUserDetail(userDetailService.findUserByEmail(getCurrentUsername())));
        vacancyService.addAndUpdateVacancy(vacancy);
        return "redirect:/hr/hrHome";
    }



    private void checkPositions(){
        if(positionNameService.getPositionNames().isEmpty()) positionNameService.initializePositionName();
        if(levelPositionService.getLevelPositions().isEmpty()) levelPositionService.initializeLevelPosition();
    }
}
