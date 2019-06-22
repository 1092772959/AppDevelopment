package com.myapp.demo.service;

import com.myapp.demo.entity.Administer;
import com.myapp.demo.entity.User;

import java.util.List;


/**
 * 管理员的事务
 */
public interface IAdministerService {

    /**
     * 查询
     */
    //根据id获取账号
    String getAccNumById(Integer id);

    //根据账号获取密码
    String getPswdByAccNum(String Accnum);

    //根据账号获取邮箱
    String getAccNumByEmail(String email);

    /**
     * 增加
     */
    void addAdminister(Administer ad);

    /**
     * 修改
     */
    void updatePswd(Integer id, String pswd);

    void updateEmail(Integer id, String email);

    /**
     * 根据账号删除
     */
    void deleteById(Integer id);

    /**
     * 根据账号获得管理员
     */
    Administer findAdministerByAccount(String acc);
}
