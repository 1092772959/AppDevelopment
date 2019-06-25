package com.myapp.demo.service;

import com.myapp.demo.entity.Prize;

import java.util.List;

public interface IPrizeService {

    /**
     * 查询
     */
    Prize getPrizeById(Integer id);

    List<Prize> getAllPrize();

    /**
     * 查询对于当前用户的奖品以及其附加属性
     * @param userId
     * @return
     */
    List<Prize> getPrizeByUserId(Integer userId);

    /**
     * 增加奖品
     */
    void addPrize(Prize prize);

    /**
     * 更新
     */
    void updateTitleById(Integer id, String title);

    void updateStepNeedById(Integer id, Integer step);

    void updateContentById(Integer id, String content);

    /**
     * 删除
     */
    void delete(Integer id);
}
