package com.myapp.demo.dao;

import com.myapp.demo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageDao extends JpaRepository<Message, Integer> {

    Message findMessageById(Integer id);

    List<Message> findAllBysenderId(Integer senderId);

    List<Message> findAllByReceivedId(Integer reveiverId);


    @Override
    <S extends Message> S save(S s);

    @Override
    void deleteById(Integer id);
}
