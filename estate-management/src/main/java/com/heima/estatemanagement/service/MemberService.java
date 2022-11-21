package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.Member;

import java.util.List;
import java.util.Map;

public interface MemberService {

    public List<Member> findAll();

    public Page<Member> search(Map searchMap);

    public Boolean add(Member member);

    public Member findById(Integer id);

    public Boolean update(Member member);


    public Boolean del(List<Integer> ids);
}
