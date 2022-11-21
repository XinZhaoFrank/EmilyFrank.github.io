package com.heima.estatemanagement.dao;

import com.heima.estatemanagement.domain.Car;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CarMapper extends Mapper<Car> {
}
