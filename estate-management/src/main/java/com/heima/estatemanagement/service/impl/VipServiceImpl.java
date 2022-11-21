package com.heima.estatemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.estatemanagement.dao.VipMapper;
import com.heima.estatemanagement.domain.Vip;
import com.heima.estatemanagement.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class VipServiceImpl implements VipService {

    @Autowired
    private VipMapper vipMapper;

    @Override
    public List<Vip> findAll() {
        List<Vip> vips = vipMapper.selectAll();
        return vips;
    }

    @Override
    public Page<Vip> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Vip.class);//指定查询的表tb_coach
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
                criteria.andLike("vipName", "%"+(String)searchMap.get("name")+"%");
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
        Page<Vip> vips = (Page<Vip>) vipMapper.selectByExample(example);
        return vips;
    }

    @Override
    public Boolean add(Vip vip) {
        int row = vipMapper.insert(vip);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Vip findById(Integer id) {
        return vipMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Vip vip) {
        int row = vipMapper.updateByPrimaryKeySelective(vip);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id:ids) {
            vipMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
