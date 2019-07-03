package org.fisco.bcos.entity;

// 用户实体，包含三种企业、音乐人、普通用户、仲裁代表
// 每种在合约中的参数名一样，但是代表内容不一样
public class User {
    private String name;   //姓名或企业名称
    private String id;     //身份证号码或者企业编码
    private String location;    //所在地
    private String phone;      //联系电话
    private String email;      //电子邮箱
    private String type;       // 用于判断是那种类型的用户

    public User() {
    }

    public User(String name, String id, String location, String phone, String email, String type){
        this.email = email;
        this.id = id;
        this.location = location;
        this.name = name;
        this.phone = phone;
        this.type =type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


}
