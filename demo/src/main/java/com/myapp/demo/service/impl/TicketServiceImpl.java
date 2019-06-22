package com.myapp.demo.service.impl;


import com.myapp.demo.dao.IMyticketDao;
import com.myapp.demo.dao.ITicketDao;
import com.myapp.demo.entity.Myticket;
import com.myapp.demo.entity.Ticket;
import com.myapp.demo.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class TicketServiceImpl implements ITicketService {

    @Autowired
    private ITicketDao ticketDao;

    @Autowired
    private IMyticketDao myticketDao;

    @Override
    public Ticket getTicketById(Integer id) {
        return ticketDao.findTicketById(id);
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketDao.findALLByOrderByReleaseTimeDesc();
    }

    @Override
    public List<Ticket> getAccessibleTicket() {
        //票数大于0才算可获取的票
        return ticketDao.findAllByCntGreaterThanOrderByReleaseTime(0);
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketDao.save(ticket);
    }

    @Override
    public void deleteTicketById(Integer id) {
        ticketDao.deleteById(id);
    }


    /**
     *  用户已抢票相关方法
     */


    @Override
    public List<Ticket> getMyTicket(Integer userId) {
        return ticketDao.findMyTicketByUserid(userId);
    }

    @Override
    public void addMyTicket(Integer userId, Integer ticketId) {
        Myticket myt = new Myticket();
        myt.setUserid(userId);
        myt.setTicketId(ticketId);
        myt.setGetTime(new Date());
        myticketDao.save(myt);
    }

    @Override
    public void deleteMyTicket(Integer userId, Integer ticketId) {
        myticketDao.deleteByUseridAndTicketId(userId, ticketId);
    }
}
