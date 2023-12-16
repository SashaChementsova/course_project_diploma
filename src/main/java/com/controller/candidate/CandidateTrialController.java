package com.controller.candidate;

import com.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CandidateTrialController {

    private final LanguageTestService languageTestService;
    private final PositionTestService positionTestService;
    private final LanguageTestQuestionService languageTestQuestionService;
    private final PositionTestQuestionService positionTestQuestionService;
    private final LanguageTestHasQuestionService languageTestHasQuestionService;
    private final PositionTestHasQuestionService positionTestHasQuestionService;
    private final ResultService resultService;
    private final ResultTestingService resultTestingService;
    private final TrialService trialService;
    private final CandidateService candidateService;
    private final UserDetailService userDetailService;
    private final InterviewService interviewService;
    private final EmployeeService employeeService;

    public CandidateTrialController(LanguageTestService languageTestService, PositionTestService positionTestService, LanguageTestQuestionService languageTestQuestionService, PositionTestQuestionService positionTestQuestionService, LanguageTestHasQuestionService languageTestHasQuestionService, PositionTestHasQuestionService positionTestHasQuestionService, ResultService resultService, ResultTestingService resultTestingService, TrialService trialService, CandidateService candidateService, UserDetailService userDetailService, InterviewService interviewService, EmployeeService employeeService) {
        this.languageTestService = languageTestService;
        this.positionTestService = positionTestService;
        this.languageTestQuestionService = languageTestQuestionService;
        this.positionTestQuestionService = positionTestQuestionService;
        this.languageTestHasQuestionService = languageTestHasQuestionService;
        this.positionTestHasQuestionService = positionTestHasQuestionService;
        this.resultService = resultService;
        this.resultTestingService = resultTestingService;
        this.trialService = trialService;
        this.candidateService = candidateService;
        this.userDetailService = userDetailService;
        this.interviewService = interviewService;
        this.employeeService = employeeService;
    }
    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @GetMapping("/candidate/trial")
    public String getTrial(Model model ){
        candidateService.checkCandidatesByTestsAndInterview();
        model.addAttribute("trial",userDetailService.findUserByEmail(getCurrentUsername()).getCandidate().getTrialEntities().get(0));
        return "candidate/trialControl/getTrial.html";
    }

    @GetMapping("/candidate/positionTest")
    public String getPositionTest(Model model ){
        candidateService.checkCandidatesByTestsAndInterview();
        model.addAttribute("candidate",userDetailService.findUserByEmail(getCurrentUsername()).getCandidate());
        model.addAttribute("test",userDetailService.findUserByEmail(getCurrentUsername()).getCandidate().getTrialEntities().get(0).getResultTesting().getPositionTest());
        if(userDetailService.findUserByEmail(getCurrentUsername()).getCandidate().getTrialEntities().get(0).getResultTesting().getPositionTest().getResult().getPoints()!=-1){
            model.addAttribute("trueInterview","trueInterview");
        }
        return "candidate/trialControl/getPositionTest.html";
    }
    @GetMapping("/candidate/languageTest")
    public String getLanguageTest(Model model ){
        candidateService.checkCandidatesByTestsAndInterview();
        model.addAttribute("candidate",userDetailService.findUserByEmail(getCurrentUsername()).getCandidate());
        if(userDetailService.findUserByEmail(getCurrentUsername()).getCandidate().getTrialEntities().get(0).getResultTesting().getLanguageTestEntities().get(0).getResult().getPoints()!=-1){
            model.addAttribute("trueInterview","trueInterview");
        }
        return "candidate/trialControl/getLanguageTest.html";
    }
    @GetMapping("/candidate/interview")
    public String getInterview(Model model ){
        candidateService.checkCandidatesByTestsAndInterview();
        model.addAttribute("trial",userDetailService.findUserByEmail(getCurrentUsername()).getCandidate().getTrialEntities().get(0));
        model.addAttribute("employee",userDetailService.findUserByEmail(getCurrentUsername()).getCandidate().getTrialEntities().get(0).getInterviewEntities().get(0).getEmployee());
        model.addAttribute("interview",userDetailService.findUserByEmail(getCurrentUsername()).getCandidate().getTrialEntities().get(0).getInterviewEntities().get(0));
        if(userDetailService.findUserByEmail(getCurrentUsername()).getCandidate().getTrialEntities().get(0).getInterviewEntities().get(0).getResult()!=null){
            if(userDetailService.findUserByEmail(getCurrentUsername()).getCandidate().getTrialEntities().get(0).getInterviewEntities().get(0).getResult().getPoints()!=-1){
                model.addAttribute("trueInterview","trueInterview");
            }
        }
        return "candidate/trialControl/getInterview.html";
    }

    @GetMapping("/candidate/resultPositionTest")
    public String getResultOfPositionTest(Model model){
        return "candidate/trialControl/resultOfPositionTest.html";
    }

    @GetMapping("/candidate/resultLanguageTest")
    public String getResultOfLanguageTest(Model model){
        return "candidate/trialControl/resultOfLanguageTest.html";
    }


}
