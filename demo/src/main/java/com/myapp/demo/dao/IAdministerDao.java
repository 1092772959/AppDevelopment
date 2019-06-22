package com.myapp.demo.dao;

import com.myapp.demo.entity.Administer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IAdministerDao extends JpaRepository<Administer, Integer> {


    /**
     * 根据id查找管理员
     */
    Administer findAdministerById(Integer id);

    /**
     *根据账号查找管理员
     */
    Administer findByAccNum(String accnum);

    /**
     * 根据邮箱查找管理员，需要确保邮箱号唯一
     */
    Administer findByEmail(String eamil);

    /**
     * 增加或更新一条记录
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends Administer> S save(S s);

    /**
     * 修改密码
     */
    @Modifying
    @Query(value="update Administer set pswd = ?2 where id = ?1")
    void updatePswdById(Integer id, String pswd);

}
