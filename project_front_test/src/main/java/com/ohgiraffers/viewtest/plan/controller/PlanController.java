package com.ohgiraffers.viewtest.plan.controller;

import com.ohgiraffers.viewtest.comp.dto.CompDTO;
import com.ohgiraffers.viewtest.comp.service.CompService;
import com.ohgiraffers.viewtest.plan.dto.PlanDTO;
import com.ohgiraffers.viewtest.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private CompService compService;

    @Autowired
    private PlanService planService;

    @GetMapping("/calender")
    public String calender(Model model){
        List<CompDTO> comps = compService.selectAllComp();
        model.addAttribute("comps", comps);

        return "calender/calender";
    }

    @PostMapping("/plan_insert")
    public String planInsert(PlanDTO planDTO){
        planService.insertPlan(planDTO);
        return "calender/calender";
    }

    @GetMapping("/mypage")
    public String myPage(Model model){
        List<PlanDTO> plans = planService.selectAllPlan();
        model.addAttribute("plans", plans);

        return "calender/myPage";
    }

}
