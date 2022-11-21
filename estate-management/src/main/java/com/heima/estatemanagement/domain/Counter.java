package com.heima.estatemanagement.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tb_counter")
public class Counter  implements Serializable {
    @Id
   private Integer id;
   private String counterName;
   private String counterSex;
   private String counterTelephone;
   private String counterAddress;
   private String counterIdCard;
   private String counterRemark;
   private Date createTime;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getCounterName() {
      return counterName;
   }

   public void setCounterName(String counterName) {
      this.counterName = counterName;
   }

   public String getCounterSex() {
      return counterSex;
   }

   public void setCounterSex(String counterSex) {
      this.counterSex = counterSex;
   }

   public String getCounterTelephone() {
      return counterTelephone;
   }

   public void setCounterTelephone(String counterTelephone) {
      this.counterTelephone = counterTelephone;
   }

   public String getCounterAddress() {
      return counterAddress;
   }

   public void setCounterAddress(String counterAddress) {
      this.counterAddress = counterAddress;
   }

   public String getCounterIdCard() {
      return counterIdCard;
   }

   public void setCounterIdCard(String counterIdCard) {
      this.counterIdCard = counterIdCard;
   }

   public String getCounterRemark() {
      return counterRemark;
   }

   public void setCounterRemark(String counterRemark) {
      this.counterRemark = counterRemark;
   }

   public Date getCreateTime() {
      return createTime;
   }

   public void setCreateTime(Date createTime) {
      this.createTime = createTime;
   }
}
