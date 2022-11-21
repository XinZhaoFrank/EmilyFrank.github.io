package com.heima.estatemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.estatemanagement.dao.CrewMapper;
import com.heima.estatemanagement.domain.Crew;
import com.heima.estatemanagement.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class CrewServiceImpl implements CrewService {

    @Autowired
    private CrewMapper crewMapper;

    @Override
    public List<Crew> findAll() {
        List<Crew> crews = crewMapper.selectAll();
        return crews;
    }

    @Override
    public Page<Crew> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Crew.class);//指定查询的表tb_crew
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
                criteria.andLike("crewName", "%"+(String)searchMap.get("name")+"%");
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
        Page<Crew> crews = (Page<Crew>) crewMapper.selectByExample(example);
        return crews;
    }

    @Override
    public Boolean add(Crew crew) {
        int row = crewMapper.insert(crew);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Crew findById(Integer id) {
        return crewMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Crew crew) {
        int row = crewMapper.updateByPrimaryKeySelective(crew);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id:ids) {
            crewMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
