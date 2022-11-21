package com.heima.estatemanagement.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tb_crew")
public class Crew implements Serializable {
    @Id
    private Integer id;
    private String crewName;
    private String crewSex;
    private String crewTelephone;
    private String crewAddress;
    private String crewIdCard;
    private String crewRemark;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public String getCrewSex() {
        return crewSex;
    }

    public void setCrewSex(String crewSex) {
        this.crewSex = crewSex;
    }

    public String getCrewTelephone() {
        return crewTelephone;
    }

    public void setCrewTelephone(String crewTelephone) {
        this.crewTelephone = crewTelephone;
    }

    public String getCrewAddress() {
        return crewAddress;
    }

    public void setCrewAddress(String crewAddress) {
        this.crewAddress = crewAddress;
    }

    public String getCrewIdCard() {
        return crewIdCard;
    }

    public void setCrewIdCard(String crewIdCard) {
        this.crewIdCard = crewIdCard;
    }

    public String getCrewRemark() {
        return crewRemark;
    }

    public void setCrewRemark(String crewRemark) {
        this.crewRemark = crewRemark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
