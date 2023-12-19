package com.ohgiraffers.viewtest.plan.dto;

import java.util.Date;

public class PlanDTO {
    private int planCode;
    private int compCode;
    private String planName;
    private String startDate;
    private String endDate;
    private Date registDate;
    private Date updateDate;

    public PlanDTO() {
    }

    public PlanDTO(int planCode, int compCode, String planName, String startDate, String endDate, Date registDate, Date updateDate) {
        this.planCode = planCode;
        this.compCode = compCode;
        this.planName = planName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registDate = registDate;
        this.updateDate = updateDate;
    }

    public int getPlanCode() {
        return planCode;
    }

    public void setPlanCode(int planCode) {
        this.planCode = planCode;
    }

    public int getCompCode() {
        return compCode;
    }

    public void setCompCode(int compCode) {
        this.compCode = compCode;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "PlanDTO{" +
                "planCode=" + planCode +
                ", compCode=" + compCode +
                ", planName='" + planName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
