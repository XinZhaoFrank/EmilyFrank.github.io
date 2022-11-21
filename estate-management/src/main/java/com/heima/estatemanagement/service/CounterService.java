package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.Counter;

import java.util.List;
import java.util.Map;

public interface CounterService {

    public List<Counter> findAll();

    public Page<Counter> search(Map searchMap);

    public Boolean add(Counter counter);

    public Counter findById(Integer id);

    public Boolean update(Counter counter);


    public Boolean del(List<Integer> ids);
}
