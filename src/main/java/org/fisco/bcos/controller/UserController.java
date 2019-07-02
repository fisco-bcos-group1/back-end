package org.fisco.bcos.controller;

import org.fisco.bcos.entity.User;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 个人中心
@Controller
public class UserController {

    //@Autowired  private Transfer transfer;
    String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
    private Transfer transfer;

    public UserController() throws Exception {
        this.transfer = new Transfer(privateKey);
    }

    // 用户信息
    @ResponseBody
    @RequestMapping("/enterprise")
    public User enterpriseInformation(String a)throws Exception{
        String name = transfer.getUserName();
        String id = transfer.getUserid();
        String location = transfer.getUserLocation();
        String phone = transfer.getUserPhone();
        String email = transfer.getUserEmail();
        User user = new User(name,id,location,phone,email);
        return user;
    }

    // 授权订单
    @RequestMapping("/")
    public String Authorize(){
        return "1";
    }


}
