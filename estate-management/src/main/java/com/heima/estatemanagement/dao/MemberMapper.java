package com.heima.estatemanagement.dao;

import com.heima.estatemanagement.domain.Member;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface MemberMapper extends Mapper<Member> {
}
