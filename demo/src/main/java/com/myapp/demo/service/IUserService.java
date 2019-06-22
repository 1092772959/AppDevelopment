package com.myapp.demo.service;

import com.myapp.demo.entity.User;

import java.util.List;


/**
 * 此接口仅负责与用户信息相关的业务，不包括计步、兑奖和消息相关的功能
 */

public interface IUserService {
    /**
     * 查询
     */
    public User getUserById(Integer id);

    //根据教职工号查找
    public User getUserByNum(Integer num);

    public List<User> getAllUsers();

    //工会用户
    public List<User> getVIP();

    //非工会用户
    public List<User> getNoVIP();

    /**
     * 修改
     */
    public void setDeviceById(Integer id, String device);

    public void setUsernameById(Integer id, String username);

    public void setEmailById(Integer id, String email);

    public void setIconPathById(Integer id, String iconPath);

    public void setBgPathById(Integer id, String bgPath);

    public void setUser(User user);

    //增加
    public void addUser(User user);

    //删除
    public void deleteUserById(Integer id);
}
