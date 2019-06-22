package com.myapp.demo.dao;

import com.myapp.demo.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReplyDao extends JpaRepository<Reply, Integer> {

    Reply findReplyById(Integer id);

    List<Reply> findAllByInquiryIdOrderByReleaseTimeAsc(Integer inquiryId);

    @Override
    <S extends Reply> S save(S s);

    @Override
    void deleteById(Integer integer);
}
