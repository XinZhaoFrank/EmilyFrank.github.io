package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.domain.Pet;
import com.heima.estatemanagement.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auth: zhuan
 * @Desc: 小区管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    
    @Autowired
    private PetService petService;

    @RequestMapping("/find")
    public Result find(){
        List<Pet> all = petService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Pet> page = petService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.PET_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Pet pet){
        Boolean add = petService.add(pet);
        return new Result(true,StatusCode.OK,MessageConstant.PET_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Pet pet = petService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.PET_FIND_BY_ID_SUCCESS,pet);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Pet pet){
        Boolean add = petService.update(pet);
        return new Result(true,StatusCode.OK,MessageConstant.PET_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = petService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.PET_DELETE_SUCCESS);
    }
}
