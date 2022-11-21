package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.Crew;

import java.util.List;
import java.util.Map;

public interface CrewService {

    public List<Crew> findAll();

    public Page<Crew> search(Map searchMap);

    public Boolean add(Crew crew);

    public Crew findById(Integer id);

    public Boolean update(Crew crew);


    public Boolean del(List<Integer> ids);
}
