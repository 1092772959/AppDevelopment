package com.myapp.demo.entity.indirect;


/**
 *  该类用于存储反应用户步数的情况
 */

public class UserStep  {

    /**
     * usernum: 用户账号
     * userName:用户名
     * step: 需要反馈的步数(日、周、月或季度)
     * total:总步数
     */

    private Integer usernum;
    private String userName;
    private Integer step;
    private Long total;

    public UserStep() {
    }

    public UserStep(Integer usernum, String userName, Integer step, Long total) {
        this.usernum = usernum;
        this.userName = userName;
        this.step = step;
        this.total = total;
    }

    public Integer getUsernum(){
        return usernum;
    }

    public void setUsernum(Integer usernum) {
        this.usernum = usernum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "UserStep{" +
                "usernum=" + usernum +
                ", userName=" + userName +
                ", step=" + step +
                ", total=" + total +
                '}';
    }
}
