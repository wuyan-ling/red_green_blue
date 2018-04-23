package com.bst.red_green_blue.pojo.vo;

/**
 * Created by 熊厚谨 on 2018/4/23 17:37
 *
 * @author 熊厚谨
 */
public class PublicFacilityManageVo {
    private String id;

    private String requestAddress;

    private String personNumber;

    private String requestUseTime;

    private String contactWay;

    private String remark;

    private String teamId;

    private Integer status;

    private String userId;

    public String getId() {
        return id;
    }

    public PublicFacilityManageVo setId(String id) {
        this.id = id;
        return this;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public PublicFacilityManageVo setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
        return this;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public PublicFacilityManageVo setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
        return this;
    }

    public String getRequestUseTime() {
        return requestUseTime;
    }

    public PublicFacilityManageVo setRequestUseTime(String requestUseTime) {
        this.requestUseTime = requestUseTime;
        return this;
    }

    public String getContactWay() {
        return contactWay;
    }

    public PublicFacilityManageVo setContactWay(String contactWay) {
        this.contactWay = contactWay;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public PublicFacilityManageVo setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getTeamId() {
        return teamId;
    }

    public PublicFacilityManageVo setTeamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public PublicFacilityManageVo setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public PublicFacilityManageVo setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public PublicFacilityManageVo() {
    }

    public PublicFacilityManageVo(String id, String requestAddress, String personNumber, String requestUseTime, String contactWay, String remark, String teamId, Integer status, String userId) {
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
}
