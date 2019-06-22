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
     * 查询当前步数能够获取的奖品
     * @param step
     * @return
     */
    List<Prize> getAccessiblePrize(Integer step);

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
