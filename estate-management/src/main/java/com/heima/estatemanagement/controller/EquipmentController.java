package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.domain.Equipment;
import com.heima.estatemanagement.service.EquipmentService;
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
@RequestMapping("/equipment")
public class EquipmentController {
    
    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping("/find")
    public Result find(){
        List<Equipment> all = equipmentService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Equipment> page = equipmentService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.EQUIPMENT_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Equipment equipment){
        Boolean add = equipmentService.add(equipment);
        return new Result(true,StatusCode.OK,MessageConstant.EQUIPMENT_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Equipment equipment = equipmentService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.EQUIPMENT_FIND_BY_ID_SUCCESS,equipment);
    }
    @RequestMapping("/update")
    public Result update(@RequestBody Equipment equipment){
        Boolean add = equipmentService.update(equipment);
        return new Result(true,StatusCode.OK,MessageConstant.EQUIPMENT_UPDATE_SUCCESS);
    }
    // /equipment/updateStatus/0/1
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status,@PathVariable("id") Integer id){
        Boolean flag = equipmentService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.EQUIPMENT_UPDATE_STATUS_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = equipmentService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.EQUIPMENT_DELETE_SUCCESS);
    }


}
