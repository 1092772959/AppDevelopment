package com.myapp.demo.dao;

import com.myapp.demo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITicketDao extends JpaRepository<Ticket, Integer> {

    @Override
    List<Ticket> findAll();

    Ticket findTicketById(Integer id);

    List<Ticket> findALLByOrderByReleaseTimeDesc();

    //查询票数大于cnt的票(用于查询有效票)
    List<Ticket> findAllByCntGreaterThanOrderByReleaseTime(Integer cnt);

    /**
     * 根据用户id查询其抢到的票
      */
    @Query(value = "select * from ticket as X where X.id in (select ticket_id from myticket where userid = ?1)", nativeQuery = true)
    List<Ticket> findMyTicketByUserid(Integer userid);

    @Override
    <S extends Ticket> S save(S s);
}
