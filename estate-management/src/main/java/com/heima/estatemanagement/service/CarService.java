package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.Car;

import java.util.List;
import java.util.Map;

public interface CarService {

    public List<Car> findAll();

    public Page<Car> search(Map searchMap);

    public Boolean add(Car car);

    public Car findById(Integer id);

    public Boolean update(Car car);


    public Boolean del(List<Integer> ids);
}
