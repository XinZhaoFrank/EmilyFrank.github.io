package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.Equipment;

import java.util.List;
import java.util.Map;

public interface EquipmentService {

    public List<Equipment> findAll();

    public Page<Equipment> search(Map searchMap);

    public Boolean add(Equipment equipment);

    public Equipment findById(Integer id);

    public Boolean update(Equipment equipment);

    public Boolean updateStatus(String status, Integer id);

    public Boolean del(List<Integer> ids);
}
