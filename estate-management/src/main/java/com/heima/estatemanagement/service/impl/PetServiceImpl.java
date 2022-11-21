package com.heima.estatemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.estatemanagement.dao.PetMapper;
import com.heima.estatemanagement.domain.Pet;
import com.heima.estatemanagement.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetMapper petMapper;

    @Override
    public List<Pet> findAll() {
        List<Pet> pets = petMapper.selectAll();
        return pets;
    }

    @Override
    public Page<Pet> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Pet.class);//指定查询的表tb_pet
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
                criteria.andLessThanOrEqualTo("createTime",searchMap.get("endTime"));
            }
            //名称模糊搜索
            if(StringUtil.isNotEmpty((String) searchMap.get("name"))){
                criteria.andLike("name", "%"+(String) searchMap.get("name")+"%");
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
        Page<Pet> pets = (Page<Pet>) petMapper.selectByExample(example);
        return pets;
    }

    @Override
    public Boolean add(Pet pet) {
        int row = petMapper.insert(pet);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Pet findById(Integer id) {
        return petMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Pet pet) {
        int row = petMapper.updateByPrimaryKeySelective(pet);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id:ids) {
            petMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

}
