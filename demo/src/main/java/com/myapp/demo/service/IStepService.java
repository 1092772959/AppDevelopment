package com.myapp.demo.service;

import com.myapp.demo.entity.User;
import com.myapp.demo.entity.indirect.UserStep;

import java.util.List;

/**
 * 此接口负责和计步相关业务
 * 查找返回间接存在的com.myapp.demo.entity.indirect.UserStep类，
 *  其中记录了计步排名必要的数据
 */

public interface IStepService {

    /**
     * 查询方法
     */
    User getUserById(Integer id);

    User getUserByNum(Integer num);

    List<UserStep> getTopToday(Integer topNum);

    List<UserStep> getTopWeek(Integer topNum);

    List<UserStep> getTopMonth(Integer topNum);

    List<UserStep> getTopSeason(Integer topNum);

    List<UserStep> getTopTotal(Integer topNum);

    /**
     * 更新，用于
     * @param id 用户id
     * @param step 步数
     */

    void setTodayStepById(Integer id, Integer step);

    void setWeekStepById(Integer id, Integer step);

    void setMonthStepById(Integer id, Integer step);

    void setSeasonStepById(Integer id, Integer step);

    void setTotalStepById(Integer id, Long step);
}
