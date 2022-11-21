package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.domain.Vip;
import com.heima.estatemanagement.service.VipService;
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
@RequestMapping("/vip")
public class VipController {
    
    @Autowired
    private VipService vipService;

    @RequestMapping("/find")
    public Result find(){
        List<Vip> all = vipService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Vip> page = vipService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.MEMBER_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Vip vip){
        Boolean add = vipService.add(vip);
        return new Result(true,StatusCode.OK,MessageConstant.MEMBER_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Vip vip = vipService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.MEMBER_FIND_BY_ID_SUCCESS,vip);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Vip vip){
        Boolean add = vipService.update(vip);
        return new Result(true,StatusCode.OK,MessageConstant.MEMBER_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = vipService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.MEMBER_DELETE_SUCCESS);
    }
}
