package com.service;

import com.model.Language;

import java.util.List;

public interface LanguageService {
    public Language addAndUpdateLanguage(Language language);

    public List<Language> getLanguages();
    public Language findLanguageById(int id);

    public void deleteLanguage(int id);
}
