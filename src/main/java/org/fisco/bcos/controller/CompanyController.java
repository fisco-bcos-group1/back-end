package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Result;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class CompanyController {

    //String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
    //String privateKey = LoginController.getPrivateKey();
    //Transfer transfer = ContractService.getTransfer(privateKey);

    /**
     * 响应企业认证
     * @return
     */
    @RequestMapping("/api/company")
    public Result RegisterCompany(@RequestBody Map<String,Object> request){
        try{
            String name = (String)request.get("name");
            String id = (String)request.get("id");
            String location = (String)request.get("location");
            String phone = (String)request.get("phone");
            String email = (String)request.get("email");
            String privateKey = (String)request.get("privateKey");
            Transfer transfer = ContractService.getTransfer(privateKey);
            transfer.registerCompany(name,id,location,phone,email);
            return new Result(1,"企业认证成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"企业认证失败");
        }
    }
}
