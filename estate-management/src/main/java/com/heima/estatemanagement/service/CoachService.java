package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.Coach;

import java.util.List;
import java.util.Map;

public interface CoachService {

    public List<Coach> findAll();

    public Page<Coach> search(Map searchMap);

    public Boolean add(Coach coach);

    public Coach findById(Integer id);

    public Boolean update(Coach coach);


    public Boolean del(List<Integer> ids);
}
