package com.myapp.demo.service;

import com.myapp.demo.entity.Ticket;

import java.util.List;

public interface ITicketService {
    Ticket getTicketById(Integer id);

    List<Ticket> getAllTicket();

    List<Ticket> getAccessibleTicket();

    void addTicket(Ticket ticket);

    void deleteTicketById(Integer id);

    /**
     * 用户查看用户已抢到的票
     */
    List<Ticket> getMyTicket(Integer userId);

    void addMyTicket(Integer userId, Integer ticketId);

    void deleteMyTicket(Integer userId, Integer ticketId);
}
