package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.domain.Repair;
import com.heima.estatemanagement.service.RepairService;
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
@RequestMapping("/repair")
public class RepairController {
    
    @Autowired
    private RepairService repairService;

    @RequestMapping("/find")
    public Result find(){
        List<Repair> all = repairService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Repair> page = repairService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.REPAIR_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Repair repair){
        Boolean add = repairService.add(repair);
        return new Result(true,StatusCode.OK,MessageConstant.REPAIR_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Repair repair = repairService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.REPAIR_FIND_BY_ID_SUCCESS,repair);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Repair repair){
        Boolean add = repairService.update(repair);
        return new Result(true,StatusCode.OK,MessageConstant.REPAIR_UPDATE_SUCCESS);
    }
    // /repair/updateStatus/0/1
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status,@PathVariable("id") Integer id){
        Boolean flag = repairService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.REPAIR_UPDATE_STATUS_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = repairService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.REPAIR_DELETE_SUCCESS);
    }
}
