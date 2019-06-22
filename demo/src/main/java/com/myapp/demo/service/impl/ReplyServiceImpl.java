package com.myapp.demo.service.impl;


import com.myapp.demo.dao.IReplyDao;
import com.myapp.demo.entity.Reply;
import com.myapp.demo.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ReplyServiceImpl implements IReplyService {
    @Autowired IReplyDao replyDao;

    @Override
    public Reply getReplyById(Integer id) {
        return replyDao.findReplyById(id);
    }

    @Override
    public List<Reply> getRepliesByInquiryId(Integer inquiryId) {
        return replyDao.findAllByInquiryIdOrderByReleaseTimeAsc(inquiryId);
    }

    @Override
    public void addReply(Reply reply) {
        replyDao.save(reply);
    }

    @Override
    public void deleteById(Integer id) {
        replyDao.deleteById(id);
    }
}
