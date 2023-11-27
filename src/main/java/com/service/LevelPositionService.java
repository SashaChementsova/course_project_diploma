package com.service;

import com.model.LevelPosition;

import java.util.List;

public interface LevelPositionService {
    public LevelPosition addAndUpdateLevelPosition(LevelPosition levelPosition);
    public List<LevelPosition> getLevelPositions();

    public LevelPosition findLevelPositionById(int id);
    public void deleteLevelPosition(int id);

    public void initializeLevelPosition();
}
