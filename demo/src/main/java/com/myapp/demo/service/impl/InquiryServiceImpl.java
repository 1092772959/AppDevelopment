package com.myapp.demo.service.impl;


import com.myapp.demo.dao.IInquiryDao;
import com.myapp.demo.entity.Inquiry;
import com.myapp.demo.service.IInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class InquiryServiceImpl implements IInquiryService {

    @Autowired
    private IInquiryDao inqDao;

    @Override
    public Inquiry getInquiryById(Integer id) {
        return inqDao.findInquiryById(id);
    }

    @Override
    public List<Inquiry> getByUserid(Integer userid) {
        return inqDao.findByUserid(userid);
    }

    @Override
    public void addInquiry(Inquiry inq) {
        inqDao.save(inq);
    }

    @Override
    public void deleteById(Integer id) {
        inqDao.deleteById(id);
    }

    @Override
    public void updateContent(Integer id, String  content) {
        Inquiry inq = inqDao.findInquiryById(id);
        inq.setContent(content);
        inqDao.save(inq);
    }
}
