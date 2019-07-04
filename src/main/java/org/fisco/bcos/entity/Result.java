package org.fisco.bcos.entity;

import java.io.Serializable;

public class Result implements Serializable {

    //判断结果
    /**
     * 1 成功
     * 0 失败
     */
    private int success;


    //返回信息
    private String message;

    private Object data;

    //private Object data;

    public Result(){
    }


    public Result(int success,String message){
        this.success = success;
        this.message =message;
    }


    public Result(int success,String message, Object obj){
        this.success = success;
        this.message =message;
        this.data = obj;
    }

    public int getSuccess(){return success;}

    public void  setSuccess(int success){this.success = success;}

    public String getMessage(){return message;}

    public void setMessage(String message){this.message = message;}

    public Object getData(){return data;}

    public void setData(Object data){this.data = data;}
}
