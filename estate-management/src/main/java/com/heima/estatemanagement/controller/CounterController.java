package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.domain.Counter;
import com.heima.estatemanagement.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auth: 赵鑫
 * @Desc: 控制层：只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/counter")
public class CounterController {
    
    @Autowired
    private CounterService counterService;

    @RequestMapping("/find")
    public Result find(){
        List<Counter> all = counterService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Counter> page = counterService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COUNTER_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Counter counter){
        Boolean add = counterService.add(counter);
        return new Result(true,StatusCode.OK,MessageConstant.COUNTER_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Counter counter = counterService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COUNTER_FIND_BY_ID_SUCCESS,counter);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Counter counter){
        Boolean add = counterService.update(counter);
        return new Result(true,StatusCode.OK,MessageConstant.COUNTER_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = counterService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COUNTER_DELETE_SUCCESS);
    }
}
