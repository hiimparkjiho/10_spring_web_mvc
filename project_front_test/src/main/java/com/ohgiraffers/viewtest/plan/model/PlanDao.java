package com.ohgiraffers.viewtest.plan.model;

import com.ohgiraffers.viewtest.plan.dto.PlanDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanDao {
    int insertPlan(PlanDTO planDTO);
    List<PlanDTO> selectAllPlan();
}
