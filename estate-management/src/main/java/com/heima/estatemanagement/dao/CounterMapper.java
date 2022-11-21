package com.heima.estatemanagement.dao;

import com.heima.estatemanagement.domain.Counter;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CounterMapper extends Mapper<Counter> {
}
