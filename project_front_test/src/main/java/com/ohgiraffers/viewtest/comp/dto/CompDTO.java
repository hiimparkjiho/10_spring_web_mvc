package com.ohgiraffers.viewtest.comp.dto;

import java.util.Date;

public class CompDTO {
    private int compCode;
    private String compName;
    private String compLat;
    private String compHar;
    private String compCategory;
    private Date registDate;
    private Date updateDate;

    public CompDTO() {
    }

    public CompDTO(int compCode, String compName, String compLat, String compHar, String compCategory, Date registDate, Date updateDate) {
        this.compCode = compCode;
        this.compName = compName;
        this.compLat = compLat;
        this.compHar = compHar;
        this.compCategory = compCategory;
        this.registDate = registDate;
        this.updateDate = updateDate;
    }

    public int getCompCode() {
        return compCode;
    }

    public void setCompCode(int compCode) {
        this.compCode = compCode;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompLat() {
        return compLat;
    }

    public void setCompLat(String compLat) {
        this.compLat = compLat;
    }

    public String getCompHar() {
        return compHar;
    }

    public void setCompHar(String compHar) {
        this.compHar = compHar;
    }

    public String getCompCategory() {
        return compCategory;
    }

    public void setCompCategory(String compCategory) {
        this.compCategory = compCategory;
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
        return "CompDTO{" +
                "compCode=" + compCode +
                ", compName='" + compName + '\'' +
                ", compLat='" + compLat + '\'' +
                ", compHar='" + compHar + '\'' +
                ", compCategory='" + compCategory + '\'' +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
