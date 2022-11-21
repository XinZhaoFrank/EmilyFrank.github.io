package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.House;

import java.util.List;
import java.util.Map;

public interface HouseService {

    public List<House> findAll();

    public Page<House> search(Map searchMap);

    public Boolean add(House house);


    public House findById(Integer id);

    public Boolean update(House house);

    public Boolean del(List<Integer> ids);
}
