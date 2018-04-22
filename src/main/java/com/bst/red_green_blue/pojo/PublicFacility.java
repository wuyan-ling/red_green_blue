package com.bst.red_green_blue.pojo;

public class PublicFacility {
    private String id;

    private Integer requestAddress;

    private String personNumber;

    private String requestUseTime;

    private String contactWay;

    private String remark;

    private String teamId;

    private Integer status;

    private String userId;

    public PublicFacility(String id, Integer requestAddress, String personNumber, String requestUseTime, String contactWay, String remark, String teamId, Integer status, String userId) {
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

    public PublicFacility() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(Integer requestAddress) {
        this.requestAddress = requestAddress;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber == null ? null : personNumber.trim();
    }

    public String getRequestUseTime() {
        return requestUseTime;
    }

    public void setRequestUseTime(String requestUseTime) {
        this.requestUseTime = requestUseTime == null ? null : requestUseTime.trim();
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay == null ? null : contactWay.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}