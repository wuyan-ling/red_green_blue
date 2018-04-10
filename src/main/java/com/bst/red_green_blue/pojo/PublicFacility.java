package com.bst.red_green_blue.pojo;

public class PublicFacility {
    private String id;

    private Integer requestAddress;

    private String personNumber;

    private String requestUseTime;

    private String contactWay;

    private String remark;

    public PublicFacility(String id, Integer requestAddress, String personNumber, String requestUseTime, String contactWay, String remark) {
        this.id = id;
        this.requestAddress = requestAddress;
        this.personNumber = personNumber;
        this.requestUseTime = requestUseTime;
        this.contactWay = contactWay;
        this.remark = remark;
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
}