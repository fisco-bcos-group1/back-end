package org.fisco.bcos.controller;

import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 个人中心
@Controller
public class UserController {

    @Autowired  private Transfer transfer;

    // 用户信息
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(String a)throws Exception{
        String result = Transfer.getUserid();
        return result;
    }

    // 授权订单
    @RequestMapping("/")
    public String Authorize(){
        return "1";
    }


}
