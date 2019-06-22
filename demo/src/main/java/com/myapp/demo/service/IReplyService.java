package com.myapp.demo.service;

import com.myapp.demo.entity.Reply;

import java.util.List;

public interface IReplyService {
    Reply getReplyById(Integer id);

    List<Reply> getRepliesByInquiryId(Integer inquiryId);

    void addReply(Reply reply);

    void deleteById(Integer id);
}
