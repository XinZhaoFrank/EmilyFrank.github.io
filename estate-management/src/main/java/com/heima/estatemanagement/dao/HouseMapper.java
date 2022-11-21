package com.heima.estatemanagement.dao;

import com.heima.estatemanagement.domain.House;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface HouseMapper extends Mapper<House> {
}
