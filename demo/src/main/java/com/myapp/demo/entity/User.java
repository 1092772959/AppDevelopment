package com.myapp.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * 用户类
 *
 */
@Entity
@Table(name="account")
public class User {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name="id")
  private Integer id;

  @Column(name = "num")
  private Integer num;

  @Column(name="username")
  private String username;

  @Column(name="type")
  private Integer type;

  @Column(name="device")
  private String device;

  @Column(name="regist_time")
  private Date registTime;

  @Column(name="email")
  private String email;

  @Column(name="today_step")
  private Integer todayStep;

  @Column(name="week_step")
  private Integer weekStep;

  @Column(name="month_step")
  private Integer monthStep;

  @Column(name="season_step")
  private Integer seasonStep;

  @Column(name="total_step")
  private Long totalStep;

  @Column(name="icon_path")
  private String iconPath;

  @Column(name="bg_path")
  private String bgPath;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }


  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }


  public Date getRegistTime() {
    return registTime;
  }

  public void setRegistTime(Date registTime) {
    this.registTime = registTime;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getIconPath() {
    return iconPath;
  }

  public void setIconPath(String iconPath) {
    this.iconPath = iconPath;
  }


  public String getBgPath() {
    return bgPath;
  }

  public void setBgPath(String bgPath) {
    this.bgPath = bgPath;
  }

  public Integer getTodayStep() {
    return todayStep;
  }

  public void setTodayStep(Integer todayStep) {
    this.todayStep = todayStep;
  }

  public Integer getWeekStep() {
    return weekStep;
  }

  public void setWeekStep(Integer weekStep) {
    this.weekStep = weekStep;
  }

  public Integer getMonthStep() {
    return monthStep;
  }

  public void setMonthStep(Integer monthStep) {
    this.monthStep = monthStep;
  }

  public Integer getSeasonStep() {
    return seasonStep;
  }

  public void setSeasonStep(Integer seasonStep) {
    this.seasonStep = seasonStep;
  }

  public Long getTotalStep() {
    return totalStep;
  }

  public void setTotalStep(Long totalStep) {
    this.totalStep = totalStep;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", num=" + num +
            ", username='" + username + '\'' +
            ", type=" + type +
            ", device='" + device + '\'' +
            ", registTime=" + registTime +
            ", email='" + email + '\'' +
            ", todayStep=" + todayStep +
            ", weekStep=" + weekStep +
            ", monthStep=" + monthStep +
            ", seasonStep=" + seasonStep +
            ", totalStep=" + totalStep +
            ", iconPath='" + iconPath + '\'' +
            ", bgPath='" + bgPath + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User account = (User) o;
    return Objects.equals(id, account.id) &&
            Objects.equals(num, account.num) &&
            Objects.equals(username, account.username) &&
            Objects.equals(type, account.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, num, username, type);
  }
}
