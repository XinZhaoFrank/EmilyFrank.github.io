package com.heima.estatemanagement.dao;

import com.heima.estatemanagement.domain.Course;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CourseMapper extends Mapper<Course> {
}
