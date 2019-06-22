package com.myapp.demo.service;

import com.myapp.demo.entity.Inquiry;
import com.myapp.demo.entity.Reply;

import java.util.List;

public interface IInquiryService {
    /**
     * 询问相关
     */
    Inquiry getInquiryById(Integer id);

    List<Inquiry> getByUserid(Integer userid);

    void addInquiry(Inquiry inq);

    void deleteById(Integer id);

    void updateContent(Integer id, String content);
}
