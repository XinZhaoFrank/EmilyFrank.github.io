package com.heima.estatemanagement.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.estatemanagement.dao.UserMapper;
import com.heima.estatemanagement.domain.User;
import com.heima.estatemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service//注意需要进行注解,不然是扫描不到这是实现层的

public class UserServiceImpl implements UserService {
//我个人觉得其实springboot是通过接口引用来确定谁是要装载的抽象层的.

    @Autowired
    private UserMapper userMapper;//没什么说的,还是自动装载了mapper抽象层


    //登录操作
    public String login(User user) {
        try {
            User userExistN = userMapper.findByName(user.getName());
            if (userExistN != null) {
                String userExistP = userMapper.findPswByName(user.getName());
                if (userExistP.equals(user.getPassword())) {
                    return user.getName() + "登录成功，欢迎您！";
                } else {
                    return "登录失败，密码错误！";
                }
            } else {
                return "登录失败,用户不存在。";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @Override
    public Boolean add(User user) {
        int row = userMapper.insert(user);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }


        @Override
        public List<User> findAll() {
            List<User> users = userMapper.selectAll();
            return users;
        }

        @Override
        public Page<User> search(Map searchMap) {
            //通用Mapper多条件搜索，标准写法
            Example example = new Example(User.class);//指定查询的表tb_user
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
            Page<User> users = (Page<User>) userMapper.selectByExample(example);
            return users;
        }

        @Override
        public User findById(Integer id) {
            return userMapper.selectByPrimaryKey(id);
        }


    @Override
    public User findByName(String userName) {
        return userMapper.findByName(userName);
    }

    @Override
        public Boolean update(User user) {
            int row = userMapper.updateByPrimaryKeySelective(user);
            if(row>0){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public Boolean updateStatus(String status, Integer id) {
            User user = new User();
            user.setId(id);
            user.setStatus(status);
            int row = userMapper.updateByPrimaryKeySelective(user);
            if(row>0){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public Boolean del(List<Integer> ids) {
            for (Integer id:ids) {
                userMapper.deleteByPrimaryKey(id);
            }
            return true;
        }

    }


