package com.heima.estatemanagement.service;

import com.heima.estatemanagement.domain.User;
import com.github.pagehelper.Page;
import java.util.List;
import java.util.Map;
public interface UserService {
    public String login(User user); //就把方法写上去,参数返回值就没了

    public Boolean add(User user);

    public List<User> findAll();

    public Page<User> search(Map searchMap);

    public User findById(Integer id);

//    public User findPswByName(String password);

    public User findByName(String userName);

    public Boolean update(User user);

    public Boolean updateStatus(String status, Integer id);

    public Boolean del(List<Integer> ids);


}







