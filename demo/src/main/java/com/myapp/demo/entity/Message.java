package com.myapp.demo.entity;


import javax.persistence.*;
import java.util.Date;


/**
 * 私信类
 */
@Table(name="message")
@Entity
public class Message {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="send_id")
    private Integer senderId;

    @Column(name="receive_id")
    private Integer receivedId;

    @Column(name="content")
    private String content;

    @Temporal(TemporalType.DATE)
    @Column(name="send_time")
    private Date sendTime;

    @Column(name="type")
    private Integer type;

    @Transient
    private User sender;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getsenderId() {
        return senderId;
    }

    public void setsenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceivedId() {
        return receivedId;
    }

    public void setReceivedId(Integer receivedId) {
        this.receivedId = receivedId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receivedId=" + receivedId +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                ", type=" + type +
                '}';
    }

    public Message() {
    }

    public Message(Integer senderId, Integer receivedId, String content, Date sendTime, Integer type, User sender) {
        this.senderId = senderId;
        this.receivedId = receivedId;
        this.content = content;
        this.sendTime = sendTime;
        this.type = type;
        this.sender = sender;
    }
}
