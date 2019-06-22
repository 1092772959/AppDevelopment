package com.myapp.demo.service;

import com.myapp.demo.entity.Message;

import java.util.List;

public interface IMessageService {

    Message getMsgById(Integer id);

    List<Message> getAllMsg();

    List<Message> getMsgBysenderId(Integer senderId);

    List<Message> getMsgByreveiverId(Integer reveiverId);

    void addMessage(Message msg);

    void deleteMsgById(Integer id);
}
