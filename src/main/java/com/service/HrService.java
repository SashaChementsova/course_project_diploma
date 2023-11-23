package com.service;

import com.model.Hr;

import java.util.List;

public interface HrService {
    public Hr addAndUpdateHr(Hr hr);
    public List<Hr> getHrs();

    public Hr findHrById(int id);
    public void deleteHr(int id);
}
