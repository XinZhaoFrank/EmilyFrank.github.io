package com.heima.estatemanagement.dao;

import com.heima.estatemanagement.domain.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {
    //@Param("username")  @Param("password") //我原来看他们还写了参数叫什么,但是我发现好像反而会造成mapper实现层参数混乱,我去掉就正常了
//    User getbycond(String name,String pwd);
    List<User> findAll();

    User findByName(String username);

    String  findPswByName(String username);

    void save(User user);
}

