package com.heima.estatemanagement.dao;

import com.heima.estatemanagement.domain.Equipment;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface EquipmentMapper extends Mapper<Equipment> {
}
