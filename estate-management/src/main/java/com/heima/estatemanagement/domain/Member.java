package com.heima.estatemanagement.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="tb_member")
public class Member {
    @Id
    private Integer id;
    private String memberName;
    private String memberSex;
    private String memberIdCard;
    private String memberTelephone;
    private String memberAddress;
    private Date createTime;
    private String memberType;
    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(String memberSex) {
        this.memberSex = memberSex;
    }

    public String getMemberIdCard() {
        return memberIdCard;
    }

    public void setMemberIdCard(String memberIdCard) {
        this.memberIdCard = memberIdCard;
    }

    public String getMemberTelephone() {
        return memberTelephone;
    }

    public void setMemberTelephone(String memberTelephone) {
        this.memberTelephone = memberTelephone;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime() {
        String type=this.memberType;
        long Time = 0L;
        switch (type){
            case "周卡会员" : Time=this.createTime.getTime()*1000*60*60*24*7;
                 break;
            case "月卡会员" : Time=this.createTime.getTime()*1000*60*60*24*30;
                 break;
            case "季卡会员" : Time=this.createTime.getTime()*1000*60*60*24*90;
                 break;
            case "年卡会员" : Time=this.createTime.getTime()*1000*60*60*24*366;
                 break;
        }
        this.endTime.setTime(Time);
    }
}
