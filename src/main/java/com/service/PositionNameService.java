package com.service;

import com.model.PositionName;

import java.util.List;

public interface PositionNameService {
    public PositionName addAndUpdatePositionName(PositionName positionName);
    public List<PositionName> getPositionNames();

    public PositionName findPositionNameById(int id);
    public void deletePositionName(int id);

    public void initializePositionName();
}
