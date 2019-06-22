package com.myapp.demo.service.impl;


import com.myapp.demo.dao.*;
import com.myapp.demo.entity.Administer;
import com.myapp.demo.service.IAdministerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdministerServiceImpl implements IAdministerService {

    @Autowired
    private IAdministerDao admDao;

    @Override
    public String getAccNumById(Integer id) {
        return admDao.findAdministerById(id).getAccNum();
    }

    @Override
    public String getPswdByAccNum(String Accnum) {
        return this.admDao.findByAccNum(Accnum).getPswd();
    }

    @Override
    public void addAdminister(Administer ad) {
        this.admDao.save(ad);
    }

    @Override
    public String getAccNumByEmail(String email) {
        return this.admDao.findByEmail(email).getAccNum();
    }

    @Override
    public void updatePswd(Integer id, String pswd) {
        this.admDao.updatePswdById(id, pswd);
    }

    @Override
    public void updateEmail(Integer id,String email) {
        Administer ad = this.admDao.findAdministerById(id);
        ad.setEmail(email);
        this.admDao.save(ad);
    }

    @Override
    public void deleteById(Integer id) {
        this.admDao.deleteById(id);
    }
}
