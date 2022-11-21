package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    public List<Course> findAll();

    public Page<Course> search(Map searchMap);

    public Boolean add(Course course);

    public Course findById(Integer id);

    public Boolean update(Course course);

    public Boolean updateStatus(String status, Integer id);

    public Boolean del(List<Integer> ids);
}
