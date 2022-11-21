package com.heima.estatemanagement.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tb_coach")
public class Coach implements Serializable {
    @Id
    private Integer id;
    private String coachName;
    private String coachTelephone;
    private String coachAddress;
    private String coachSex;
    private String coachIdCard;
    private String coachDescription;
    private Date   createTime;
    private  String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getCoachTelephone() {
        return coachTelephone;
    }

    public void setCoachTelephone(String coachTelephone) {
        this.coachTelephone = coachTelephone;
    }

    public String getCoachAddress() {
        return coachAddress;
    }

    public void setCoachAddress(String coachAddress) {
        this.coachAddress = coachAddress;
    }

    public String getCoachSex() {
        return coachSex;
    }

    public void setCoachSex(String coachSex) {
        this.coachSex = coachSex;
    }

    public String getCoachIdCard() {
        return coachIdCard;
    }

    public void setCoachIdCard(String coachIdCard) {
        this.coachIdCard = coachIdCard;
    }


    public String getCoachDescription() {
        return coachDescription;
    }

    public void setCoachDescription(String coachDescription) {
        this.coachDescription = coachDescription;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
