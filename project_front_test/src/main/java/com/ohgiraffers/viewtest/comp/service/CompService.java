package com.ohgiraffers.viewtest.comp.service;

import com.ohgiraffers.viewtest.comp.dto.CompDTO;
import com.ohgiraffers.viewtest.comp.model.CompDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompService {
    @Autowired
    private CompDao compDao;
    public List<CompDTO> selectAllComp(){
        List<CompDTO> comps = compDao.selectAllComp();
        return comps;
    }
}
