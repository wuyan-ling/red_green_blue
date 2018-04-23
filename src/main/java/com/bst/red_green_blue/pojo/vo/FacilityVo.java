package com.bst.red_green_blue.pojo.vo;

/**
 * Created by 熊厚谨 on 2018/4/23 17:23
 *
 * @author 熊厚谨
 */
public class FacilityVo {
    private String id;

    private String requestAddress;

    private String personNumber;

    private String requestUseTime;

    private String contactWay;

    private String remark;

    private String teamId;

    private Integer status;

    private String userId;

    public FacilityVo(String id, String requestAddress, String personNumber, String requestUseTime, String contactWay, String remark, String teamId, Integer status, String userId) {
        this.id = id;
        this.requestAddress = requestAddress;
        this.personNumber = personNumber;
        this.requestUseTime = requestUseTime;
        this.contactWay = contactWay;
        this.remark = remark;
        this.teamId = teamId;
        this.status = status;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public String getRequestUseTime() {
        return requestUseTime;
    }

    public String getContactWay() {
        return contactWay;
    }

    public String getRemark() {
        return remark;
    }

    public String getTeamId() {
        return teamId;
    }

    public Integer getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }
}
