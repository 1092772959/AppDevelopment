package com.myapp.demo.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class MyPrize {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="prize_id")
    private Integer prizeId;

    @Column(name="get_time")
    private Date getTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    @Override
    public String toString() {
        return "MyPrize{" +
                "id=" + id +
                ", userId=" + userId +
                ", prizeId=" + prizeId +
                ", getTime=" + getTime +
                '}';
    }
}
