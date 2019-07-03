package org.fisco.bcos.controller;

import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.fisco.bcos.service.CreateUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JudgeController {
    String privateKey = LoginController.getPrivateKey();
    Transfer transfer = ContractService.getTransfer(privateKey);

    /**
     * 响应申请认证仲裁机构
     */
    @RequestMapping("/")
    public List<String> Register(@RequestParam("name") String name,
                                 @RequestParam("location") String location,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("email") String email){
        transfer.registerUser(name,"0",location,phone,email);
        return CreateUser.createRomdonUser();
    }
}
