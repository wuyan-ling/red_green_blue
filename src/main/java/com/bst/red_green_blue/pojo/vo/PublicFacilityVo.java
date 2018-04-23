package com.bst.red_green_blue.pojo.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author XHJ
 * 2018/4/11 23:32
 */
public class PublicFacilityVo {

    @NotNull(message = "申请地址不能为空")
    private String requestAddress;
    @NotBlank(message = "使用人数范围不能为空")
    private String personNumber;
    @NotBlank(message = "使用时间不能为空")
    private String requestUseTime;
    @NotBlank(message = "联系方式不能为空")
    private String contactWay;

    private String remark;

    public PublicFacilityVo(String requestAddress, String personNumber, String requestUseTime, String contactWay, String remark) {
        this.requestAddress = requestAddress;
        this.personNumber = personNumber;
        this.requestUseTime = requestUseTime;
        this.contactWay = contactWay;
        this.remark = remark;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public PublicFacilityVo setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
        return this;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public PublicFacilityVo setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
        return this;
    }

    public String getRequestUseTime() {
        return requestUseTime;
    }

    public PublicFacilityVo setRequestUseTime(String requestUseTime) {
        this.requestUseTime = requestUseTime;
        return this;
    }

    public String getContactWay() {
        return contactWay;
    }

    public PublicFacilityVo setContactWay(String contactWay) {
        this.contactWay = contactWay;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public PublicFacilityVo setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    @Override
    public String toString() {
        return "PublicFacilityVo{" +
                "requestAddress=" + requestAddress +
                ", personNumber='" + personNumber + '\'' +
                ", requestUseTime='" + requestUseTime + '\'' +
                ", contactWay='" + contactWay + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
