package com.heima.estatemanagement.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.domain.User;
import com.heima.estatemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController//告诉springboot这是controller层,记得把映射搞上去
@RequestMapping("/user")//整个类的映射地址,后面方法映射地址是叠加的

public class UserController {
    @Autowired//这里是调用的service抽象层的类,以后用,这里的@Autowired应该是说把service实现层的方法加载到这个抽象层容器里
    private  UserService userService;

    @RequestMapping("/add")
    public Result add(@RequestBody User user){
        Boolean add = userService.add(user);
        return new Result(true, StatusCode.OK, MessageConstant.USER_ADD_SUCCESS);
    }

    @RequestMapping("/find")
    public Result find(){
        List<User> all = userService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<User> page = userService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.USER_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        User user = userService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.USER_FIND_BY_ID_SUCCESS,user);
    }
    @RequestMapping("/findByName")
    public Result findPswByName(String  userName){
        User user = userService.findByName(userName);
        return new Result(true,StatusCode.OK,MessageConstant.USER_FIND_BY_ID_SUCCESS,user);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody User user){
        Boolean add = userService.update(user);
        return new Result(true,StatusCode.OK,MessageConstant.USER_UPDATE_SUCCESS);
    }

    // /community/updateStatus/0/1
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status,@PathVariable("id") Integer id){
        Boolean flag = userService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.USER_UPDATE_STATUS_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = userService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.USER_DELETE_SUCCESS);
    }
/*
    @ResponseBody //加上这个注解,返回的就不是地址了,而是一段文本,我这只是看下成功没,正常应该在成功后跳转到其他页面
    @RequestMapping("/login")//映射嘛
    public Result login(@RequestParam(name = "username", required = true) String username,
                        @RequestParam(name = "password", required = true) String password, HttpServletRequest req,
                        HttpServletResponse res) {//在这里引入了参数,也就是前端传进来的参数,似乎@RequestParam可以去找传进来的参数,
                       // 当然是用name进行匹配了,
                     //下面两个对象,我其实不知道为啥要加,但是调试的时候总是出错,然后试了一下设置返回文本的格式居然就可以了,我^&*&
        res.setCharacterEncoding("utf-8");
        User user = userService.login(username, password);//调用service层抽象类方法,返回一个承接了数据库返回值的实体类
        if (user != null) {//很简单的逻辑,返回的只要不是空值就说明是存在的,ok
           if (user.getName().equals(username)&&user.getPassword().equals(password)){
               return   new Result(true,StatusCode.OK,MessageConstant.USER_ADD_SUCCESS);
           }


        }
        return  new Result(false,StatusCode.ERROR,MessageConstant.SYSTEM_BUSY);//返回到另一个界面,但是目前还没做
    }*/
//登录
@RequestMapping("/login")
public String login(User user){
    return userService.login(user);
}


}







