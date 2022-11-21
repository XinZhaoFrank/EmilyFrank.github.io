package com.heima.estatemanagement.dao;

import com.heima.estatemanagement.domain.Owner;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OwnerMapper extends Mapper<Owner> {
}
