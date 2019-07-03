package org.fisco.bcos.entity;

import java.io.Serializable;

public class Result implements Serializable {

    //判断结果
    private boolean success;
    //返回信息
    private String message;

    //private Object data;

    public Result(){
    }

    /*
    public Result(boolean success,String message,Object data){
        this.success = success;
        this.message =message;
        this.data = data;
    }

     */

    public Result(boolean success,String message){
        this.success = success;
        this.message =message;
    }

    public boolean isSuccess(){return success;}

    public void  setSuccess(boolean success){this.success = success;}

    public String getMessage(){return message;}

    public void setMessage(String message){this.message = message;}

    //public Object getData(){return data;}

    //public void setData(Object data){this.data = data;}
}
