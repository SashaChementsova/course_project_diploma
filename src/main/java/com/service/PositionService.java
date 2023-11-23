package com.service;

import com.model.Position;

import java.util.List;

public interface PositionService {
    public Position addAndUpdatePosition(Position position);
    public List<Position> getPositions();

    public Position findPositionById(int id);
    public void deletePosition(int id);
}
