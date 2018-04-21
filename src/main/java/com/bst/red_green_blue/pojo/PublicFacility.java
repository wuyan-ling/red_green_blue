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

    public String getId() {
        return id;
    }

    public PublicFacility setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getRequestAddress() {
        return requestAddress;
    }

    public PublicFacility setRequestAddress(Integer requestAddress) {
        this.requestAddress = requestAddress;
        return this;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public PublicFacility setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
        return this;
    }

    public String getRequestUseTime() {
        return requestUseTime;
    }

    public PublicFacility setRequestUseTime(String requestUseTime) {
        this.requestUseTime = requestUseTime;
        return this;
    }

    public String getContactWay() {
        return contactWay;
    }

    public PublicFacility setContactWay(String contactWay) {
        this.contactWay = contactWay;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public PublicFacility setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getTeamId() {
        return teamId;
    }

    public PublicFacility setTeamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public PublicFacility setStatus(Integer status) {
        this.status = status;
        return this;
    }
}