package org.fisco.bcos.entity;

/**
 * 依次包含授权人姓名、联系电话
 * 用于授权中的授权人信息
 * 准确的说应该是申请授权人信息
 */
public class Record {

    private String name;
    private String phoneNumber;

    public Record() {
    }


    public Record(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){return this.name;}
    public String getPhoneNumber(){return phoneNumber;}
}
