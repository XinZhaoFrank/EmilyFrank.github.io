package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.domain.House;
import com.heima.estatemanagement.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auth: zhao
 * @Desc: 小区管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    
    @Autowired
    private HouseService houseService;

    @RequestMapping("/find")
    public Result find(){
        List<House> all = houseService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<House> page = houseService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.House_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody House house){
        Boolean add = houseService.add(house);
        return new Result(true,StatusCode.OK,MessageConstant.House_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        House house = houseService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.House_FIND_BY_ID_SUCCESS,house);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody House house){
        Boolean add = houseService.update(house);
        return new Result(true,StatusCode.OK,MessageConstant.House_UPDATE_SUCCESS);
    }
    // /house/updateStatus/0/1

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = houseService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.House_DELETE_SUCCESS);
    }
}
