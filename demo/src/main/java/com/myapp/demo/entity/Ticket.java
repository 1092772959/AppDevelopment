package com.myapp.demo.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="ticket")
public class Ticket {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name="id")
  private Integer id;

  private Integer adminId;

  @Column(name="title")
  private String title;

  @Column(name="cnt")
  private Integer cnt;

  @Column(name="content")
  private String content;

  @Temporal(TemporalType.DATE)
  @Column(name="release_time")
  private Date releaseTime;

  @Temporal(TemporalType.DATE)
  @Column(name="deadline")
  private Date deadline;

  @Column(name="icon_path")
  private String iconPath;

  @Column(name="vedio_path")
  private String vedioPath;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public Integer getCnt() {
    return cnt;
  }

  public void setCnt(Integer cnt) {
    this.cnt = cnt;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public Date getReleaseTime() {
    return releaseTime;
  }

  public void setReleaseTime(Date releaseTime) {
    this.releaseTime = releaseTime;
  }


  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }


  public String getIconPath() {
    return iconPath;
  }

  public void setIconPath(String iconPath) {
    this.iconPath = iconPath;
  }


  public String getVedioPath() {
    return vedioPath;
  }

  public void setVedioPath(String vedioPath) {
    this.vedioPath = vedioPath;
  }

  @Override
  public String toString() {
    return "Ticket{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", cnt=" + cnt +
            ", content='" + content + '\'' +
            ", releaseTime=" + releaseTime +
            ", deadline=" + deadline +
            ", iconPath='" + iconPath + '\'' +
            ", vedioPath='" + vedioPath + '\'' +
            '}';
  }
}
