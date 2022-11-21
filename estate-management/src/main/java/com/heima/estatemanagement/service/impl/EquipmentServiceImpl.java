package com.heima.estatemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.estatemanagement.dao.EquipmentMapper;
import com.heima.estatemanagement.domain.Equipment;
import com.heima.estatemanagement.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> findAll() {
        List<Equipment> communities = equipmentMapper.selectAll();
        return communities;
    }

    @Override
    public Page<Equipment> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Equipment.class);//指定查询的表tb_equipment
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
                criteria.andLike("equipmentName", "%"+(String) searchMap.get("name")+"%");
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
        Page<Equipment> equipments = (Page<Equipment>) equipmentMapper.selectByExample(example);
        return equipments;
    }

    @Override
    public Boolean add(Equipment equipment) {
        int row = equipmentMapper.insert(equipment);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Equipment findById(Integer id) {
        return equipmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Equipment equipment) {
        int row = equipmentMapper.updateByPrimaryKeySelective(equipment);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public Boolean updateStatus(String status, Integer id) {
        Equipment equipment = new Equipment();
        equipment.setId(id);
        equipment.setStatus(status);
        int row = equipmentMapper.updateByPrimaryKeySelective(equipment);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id:ids) {
            equipmentMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

}
