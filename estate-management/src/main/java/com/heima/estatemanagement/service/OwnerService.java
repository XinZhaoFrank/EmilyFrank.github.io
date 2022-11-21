package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.Owner;

import java.util.List;
import java.util.Map;

public interface OwnerService {

    public List<Owner> findAll();

    public Page<Owner> search(Map searchMap);

    public Boolean add(Owner owner);

    public Owner findById(Integer id);

    public Boolean update(Owner owner);


    public Boolean del(List<Integer> ids);
}
