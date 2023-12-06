package com.service.serviceImpl;

import com.comparators.hrComparator;
import com.model.Hr;
import com.model.UserDetail;
import com.repository.HrRepository;
import com.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HrServiceImpl implements HrService {
    private final HrRepository hrRepository;
    @Autowired
    public HrServiceImpl(HrRepository hrRepository){
        this.hrRepository = hrRepository;
    }
    @Override
    public Hr addAndUpdateHr(Hr hr){
        return hrRepository.save(hr);
    }
    @Override
    public List<Hr> getHrs(){
        List<Hr> hrs = hrRepository.findAll();
        hrs.sort(new hrComparator());
        return hrs;
    }
    @Override
    public Hr findHrById(int id){

        return hrRepository.findById(id).orElse(null);
    }

    @Override
    public Hr findHrByUserDetail(UserDetail userDetail){

        return hrRepository.findByUserDetail(userDetail);
    }
    @Override
    public void deleteHr(int id){
        hrRepository.deleteById(id);
    }


}
