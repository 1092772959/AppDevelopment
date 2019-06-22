package com.myapp.demo.dao;

import com.myapp.demo.entity.Myticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMyticketDao extends JpaRepository<Myticket, Integer> {

    /**
     * 保存
     */
    @Override
    <S extends Myticket> S save(S s);

    /**
     *
     */
    @Override
    void deleteById(Integer integer);

    void deleteByUseridAndTicketId(Integer userId, Integer ticketId);
}
