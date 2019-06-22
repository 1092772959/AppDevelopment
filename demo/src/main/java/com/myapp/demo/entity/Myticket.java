package com.myapp.demo.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="myticket")
public class Myticket {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name="id")
  private Integer id;
  
  @Column(name="userid")
  private Integer userid;
  
  @Column(name="ticket_id")
  private Integer ticketId;

  @Column(name="get_time")
  private Date getTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }


  public Integer getTicketId() {
    return ticketId;
  }

  public void setTicketId(Integer ticketId) {
    this.ticketId = ticketId;
  }

  public Date getGetTime() {
    return getTime;
  }

  public void setGetTime(Date getTime) {
    this.getTime = getTime;
  }

  @Override
  public String toString() {
    return "Myticket{" +
            "id=" + id +
            ", userid=" + userid +
            ", ticketId=" + ticketId +
            ", getTime=" + getTime +
            '}';
  }
}
