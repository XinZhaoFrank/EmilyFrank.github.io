package com.heima.estatemanagement.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tb_vip")
public class Vip implements Serializable {
    @Id
    private Integer id;
    private String vipName;
    private String vipSex;
    private String vipIdCard;
    private String vipTelephone;
    private String vipAddress;
    private Date createTime;
    private String vipType;
    private Integer vipLeft;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getVipSex() {
        return vipSex;
    }

    public void setVipSex(String vipSex) {
        this.vipSex = vipSex;
    }

    public String getVipIdCard() {
        return vipIdCard;
    }

    public void setVipIdCard(String vipIdCard) {
        this.vipIdCard = vipIdCard;
    }

    public String getVipTelephone() {
        return vipTelephone;
    }

    public void setVipTelephone(String vipTelephone) {
        this.vipTelephone = vipTelephone;
    }

    public String getVipAddress() {
        return vipAddress;
    }

    public void setVipAddress(String vipAddress) {
        this.vipAddress = vipAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public Integer getVipLeft() {
        return vipLeft;
    }

    public void setVipLeft(Integer vipLeft) {
        this.vipLeft = vipLeft;
    }
}
