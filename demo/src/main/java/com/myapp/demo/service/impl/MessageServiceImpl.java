package com.myapp.demo.service.impl;


import com.myapp.demo.dao.IMessageDao;
import com.myapp.demo.entity.Message;
import com.myapp.demo.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessageDao msgDao;

    @Override
    public Message getMsgById(Integer id) {
        return msgDao.findMessageById(id);
    }

    @Override
    public List<Message> getAllMsg() {
        return msgDao.findAll();
    }

    @Override
    public List<Message> getMsgBysenderId(Integer senderId) {
        return msgDao.findAllBysenderId(senderId);
    }

    @Override
    public List<Message> getMsgByreveiverId(Integer reveiverId) {
        return msgDao.findAllByReceivedId(reveiverId);
    }

    @Override
    public void addMessage(Message msg) {
        msgDao.save(msg);
    }

    @Override
    public void deleteMsgById(Integer id) {
        msgDao.deleteById(id);
    }
}
