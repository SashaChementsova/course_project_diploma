package com.controller.candidate;

import com.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
public class CandidateTestingController {
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

    public CandidateTestingController(LanguageTestService languageTestService, PositionTestService positionTestService, LanguageTestQuestionService languageTestQuestionService, PositionTestQuestionService positionTestQuestionService, LanguageTestHasQuestionService languageTestHasQuestionService, PositionTestHasQuestionService positionTestHasQuestionService, ResultService resultService, ResultTestingService resultTestingService, TrialService trialService, CandidateService candidateService, UserDetailService userDetailService) {
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
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

}
