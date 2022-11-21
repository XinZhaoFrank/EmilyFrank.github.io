package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.Vip;

import java.util.List;
import java.util.Map;

public interface VipService {

    public List<Vip> findAll();

    public Page<Vip> search(Map searchMap);

    public Boolean add(Vip vip);

    public Vip findById(Integer id);

    public Boolean update(Vip vip);

    public Boolean del(List<Integer> ids);
}
