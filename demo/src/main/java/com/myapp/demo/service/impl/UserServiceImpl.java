package com.myapp.demo.service.impl;

import com.myapp.demo.dao.IUserDao;
import com.myapp.demo.entity.User;
import com.myapp.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

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
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public List<User> getVIP() {
        return userDao.findAllByTypeGreaterThanEqual(1);
    }

    @Override
    public List<User> getNoVIP() {
        return userDao.findAllByTypeLessThanEqual(0);
    }

    @Override
    public void setDeviceById(Integer id, String device) {
        userDao.updateDeviceById(id,device);
    }

    @Override
    public void setUsernameById(Integer id, String username) {
        userDao.updateUsernameById(id,username);
    }

    @Override
    public void setEmailById(Integer id, String email) {
        userDao.updateEmailById(id,email);
    }

    @Override
    public void setIconPathById(Integer id, String iconPath) {
        userDao.updateIconById(id,iconPath);
    }

    @Override
    public void setBgPathById(Integer id, String bgPath) {
        userDao.updateBackgroundById(id,bgPath);
    }

    @Override
    public void setUser(User user) {
        userDao.save(user);
    }

    @Override
    public void addUser(User user) {
        this.userDao.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.userDao.deleteById(id);
    }
}
