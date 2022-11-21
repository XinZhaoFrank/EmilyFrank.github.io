package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.domain.Course;
import com.heima.estatemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auth: 赵
 * @Desc: 小区管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @RequestMapping("/find")
    public Result find(){
        List<Course> all = courseService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Course> page = courseService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COURSE_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Course course){
        Boolean add = courseService.add(course);
        return new Result(true,StatusCode.OK,MessageConstant.COURSE_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Course course = courseService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COURSE_FIND_BY_ID_SUCCESS,course);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Course course){
        Boolean add = courseService.update(course);
        return new Result(true,StatusCode.OK,MessageConstant.COURSE_UPDATE_SUCCESS);
    }
    // /course/updateStatus/0/1
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status,@PathVariable("id") Integer id){
        Boolean flag = courseService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.COURSE_UPDATE_STATUS_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = courseService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COURSE_DELETE_SUCCESS);
    }
}
