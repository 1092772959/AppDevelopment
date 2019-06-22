package com.myapp.demo.service.impl;

import com.myapp.demo.dao.IUserDao;
import com.myapp.demo.entity.User;
import com.myapp.demo.entity.indirect.UserStep;
import com.myapp.demo.service.IStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class StepServiceImpl implements IStepService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public User getUserByNum(Integer num) {
        return userDao.findByNum(num);
    }

    @Override
    public List<UserStep> getTopToday(Integer topNum) {
        return userDao.findTopOrderByTodayStep().subList(0,topNum);
    }

    @Override
    public List<UserStep> getTopWeek(Integer topNum) {
        return userDao.findTopOrderByWeekStep().subList(0,topNum);
    }

    @Override
    public List<UserStep> getTopMonth(Integer topNum) {
        return userDao.findTopOrderByMonthStep().subList(0,topNum);
    }

    @Override
    public List<UserStep> getTopSeason(Integer topNum) {
        return userDao.findTopOrderBySesonStep().subList(0,topNum);
    }

    @Override
    public List<UserStep> getTopTotal(Integer topNum) {
        return userDao.findTopOrderByTotalStep().subList(0,topNum);
    }

    @Override
    public void setTodayStepById(Integer id, Integer step) {
        userDao.updateTodayStepById(id, step);
    }

    @Override
    public void setWeekStepById(Integer id, Integer step) {
        userDao.updateWeekStepById(id, step);
    }

    @Override
    public void setMonthStepById(Integer id, Integer step) {
        userDao.updateMonthStepById(id, step);
    }

    @Override
    public void setSeasonStepById(Integer id, Integer step) {
        userDao.updateSeasonStepById(id, step);
    }

    @Override
    public void setTotalStepById(Integer id, Long step) {
        userDao.updateTotalStepById(id, step);
    }
}
