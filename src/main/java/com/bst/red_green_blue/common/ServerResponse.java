package com.bst.red_green_blue.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @author summer
 * @version 1.0.0
 */

//@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
////保证序列化json的时候,如果是null的对象,key也会消失
//public class ServerResponse<T> implements Serializable {
//
//    private int status;
//    private String msg;
//    private T data;
//
//    public ServerResponse() {
//    }
//
//    private ServerResponse(int status){
//        this.status = status;
//    }
//    private ServerResponse(int status,T data){
//        this.status = status;
//        this.data = data;
//    }
//
//    private ServerResponse(int status,String msg,T data){
//        this.status = status;
//        this.msg = msg;
//        this.data = data;
//    }
//
//    private ServerResponse(int status,String msg){
//        this.status = status;
//        this.msg = msg;
//    }
//
//    @JsonIgnore
//    //使之不在json序列化结果当中
//    public boolean isSuccess(){
//        return this.status ==Integer.valueOf(ResponseCode.SUCCESS.getCode()) ;
//    }
//
//    public int getStatus(){
//        return status;
//    }
//    public T getData(){
//        return data;
//    }
//    public String getMsg(){
//        return msg;
//    }
//
//
//    public static <T> ServerResponse<T> createBySuccess(){
//        return new ServerResponse<T>(Integer.valueOf(ResponseCode.SUCCESS.getCode()));
//    }
//
//    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
//        return new ServerResponse<T>(Integer.valueOf(ResponseCode.SUCCESS.getCode()),msg);
//    }
//
//    public static <T> ServerResponse<T> createBySuccess(T data){
//        return new ServerResponse<T>(Integer.valueOf(ResponseCode.SUCCESS.getCode()),data);
//    }
//
//    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
//        return new ServerResponse<T>(Integer.valueOf(ResponseCode.SUCCESS.getCode()),msg,data);
//    }
//
//
//    public static <T> ServerResponse<T> createByError(){
//        return new ServerResponse<T>(Integer.valueOf(ResponseCode.ERROR.getCode()),ResponseCode.ERROR.getDesc());
//    }
//
//
//    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
//        return new ServerResponse<T>(Integer.valueOf(ResponseCode.ERROR.getCode()) ,errorMessage);
//    }
//
//    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
//        return new ServerResponse<T>(errorCode,errorMessage);
//    }
//
//    @Override
//    public String toString() {
//        if (this.data != null){
//            return "ServerResponse{" +
//                    "status=" + status +
//                    ", msg='" + msg + '\'' +
//                    ", data=" + data.toString() +
//                    '}';
//        }
//        return "ServerResponse{" +
//                "status=" + status +
//                ", msg='" + msg + '\'' +
//                ", data= null"  +
//                '}';
//    }
//}

@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    public ServerResponse() {
    }

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.status ==Integer.valueOf(ResponseCode.SUCCESS.getCode()) ;
    }

    public int getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }


    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(Integer.valueOf(ResponseCode.SUCCESS.getCode()));
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(Integer.valueOf(ResponseCode.SUCCESS.getCode()),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(Integer.valueOf(ResponseCode.SUCCESS.getCode()),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(Integer.valueOf(ResponseCode.SUCCESS.getCode()),msg,data);
    }


    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(Integer.valueOf(ResponseCode.ERROR.getCode()),ResponseCode.ERROR.getDesc());
    }


    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(Integer.valueOf(ResponseCode.ERROR.getCode()) ,errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }
    @Override
    public String toString() {
        if (this.data != null){
            return "ServerResponse{" +
                    "status=" + status +
                    ", msg='" + msg + '\'' +
                    ", data=" + data.toString() +
                    '}';
        }
        return "ServerResponse{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data= null"  +
                '}';
    }
}