package com.ohgiraffers.viewtest.plan.service;

import com.ohgiraffers.viewtest.plan.dto.PlanDTO;
import com.ohgiraffers.viewtest.plan.model.PlanDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    private PlanDao planDao;

    public PlanService(PlanDao planDao) {
        this.planDao = planDao;
    }

    public int insertPlan(PlanDTO planDTO){

        int result = planDao.insertPlan(planDTO);
        if(result < 0) {
            System.out.println("실패");
        }else{
            System.out.println("성공");
        }
        return result;
    }

    public List<PlanDTO> selectAllPlan(){
        return planDao.selectAllPlan();
    }
}
