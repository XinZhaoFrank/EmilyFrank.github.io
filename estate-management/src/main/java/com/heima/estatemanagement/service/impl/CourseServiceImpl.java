package com.heima.estatemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.estatemanagement.dao.CourseMapper;
import com.heima.estatemanagement.domain.Course;
import com.heima.estatemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        List<Course> courses = courseMapper.selectAll();
        return courses;
    }

    @Override
    public Page<Course> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Course.class);//指定查询的表tb_crew
        //1.初始化分页条件
        int pageNum = 1;
        int pageSize = 2;
        if(searchMap != null){
            Example.Criteria criteria = example.createCriteria();//创建查询条件
            //时间区间
            if(StringUtil.isNotEmpty((String) searchMap.get("startTime"))){
                criteria.andGreaterThanOrEqualTo("createTime",searchMap.get("startTime"));
            }
            if(StringUtil.isNotEmpty((String) searchMap.get("endTime"))){
                criteria.andLessThanOrEqualTo("createTime",searchMap.get("endTime"));
            }
            //名称模糊搜索
            if(StringUtil.isNotEmpty((String) searchMap.get("name"))){
                criteria.andLike("courseName", "%"+(String)searchMap.get("name")+"%");
            }
            //分页
            /*if(StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if(StringUtil.isNotEmpty((String) searchMap.get("pageSize"))){
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }*/
            if((Integer) searchMap.get("pageNum") !=null){
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if((Integer) searchMap.get("pageSize") !=null){
                pageSize = (Integer) searchMap.get("pageSize");
            }
        }
        PageHelper.startPage(pageNum,pageSize);//使用PageHelper插件完成分页
        Page<Course> courses = (Page<Course>) courseMapper.selectByExample(example);
        return courses;
    }

    @Override
    public Boolean add(Course course) {
        int row = courseMapper.insert(course);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Course findById(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Course course) {
        int row = courseMapper.updateByPrimaryKeySelective(course);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean updateStatus(String status, Integer id) {
        Course course = new Course();
        course.setId(id);
        course.setStatus(status);
        int row = courseMapper.updateByPrimaryKeySelective(course);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id:ids) {
            courseMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

}
