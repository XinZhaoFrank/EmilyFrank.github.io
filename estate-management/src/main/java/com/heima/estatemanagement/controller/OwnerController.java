package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.domain.Owner;
import com.heima.estatemanagement.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auth: 赵鑫
 * @Desc: 小区管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {
    
    @Autowired
    private OwnerService ownerService;

    @RequestMapping("/find")
    public Result find(){
        List<Owner> all = ownerService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Owner> page = ownerService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.OWNER_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Owner owner){
        Boolean add = ownerService.add(owner);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Owner owner = ownerService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_FIND_BY_ID_SUCCESS,owner);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Owner owner){
        Boolean add = ownerService.update(owner);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = ownerService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.OWNER_DELETE_SUCCESS);
    }
}
