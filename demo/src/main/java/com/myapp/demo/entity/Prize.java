package com.myapp.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="prize")
public class Prize {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name="id")
  private Integer id;

  @Column(name="adminId")
  private Integer adminId;

  @Column(name="title")
  private String title;

  @Column(name="step_need")
  private Integer stepNeed;

  @Column(name="content")
  private String content;

  @Column(name="src_url")
  private String srcUrl;

  //表示是否对于该用户是否兑换过
  @Transient
  private Boolean redeemed;

  //表示是否对于该用户是否可兑换
  @Transient
  private Boolean available;

  public Boolean getRedeemed() {
    return redeemed;
  }

  public void setRedeemed(Boolean redeemed) {
    this.redeemed = redeemed;
  }

  public Boolean getAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getStepNeed() {
    return stepNeed;
  }

  public void setStepNeed(Integer stepNeed) {
    this.stepNeed = stepNeed;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSrcUrl() {
    return srcUrl;
  }

  public void setSrcUrl(String srcUrl) {
    this.srcUrl = srcUrl;
  }

  @Override
  public String toString() {
    return "Prize{" +
            "id=" + id +
            ", adminId=" + adminId +
            ", title='" + title + '\'' +
            ", stepNeed=" + stepNeed +
            ", content='" + content + '\'' +
            ", srcUrl='" + srcUrl + '\'' +
            ", redeemed=" + redeemed +
            ", available=" + available +
            '}';
  }
}
