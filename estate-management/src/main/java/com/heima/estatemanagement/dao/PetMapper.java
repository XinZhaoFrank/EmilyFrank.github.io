package com.heima.estatemanagement.dao;

import com.heima.estatemanagement.domain.Pet;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface PetMapper extends Mapper<Pet> {
}
