package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Notice;
import org.fisco.bcos.entity.Record;
import org.fisco.bcos.entity.Result;
import org.fisco.bcos.entity.User;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用于相应个人中心
 */
@RestController
public class UserController {

    //@Autowired  private Transfer transfer;


    //String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
    String privateKey = LoginController.getPrivateKey();
    Transfer transfer = ContractService.getTransfer(privateKey);

    // 用户信息
    // 可用于企业、音乐人、普通用户
    @RequestMapping("/")
    public Result<User> enterpriseInformation(){
        try{
            User user = transfer.getUser();
            return new Result<User>(1,"用户信息返回成功",user);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"用户信息返回失败");
        }
    }


    // 授权订单
    @RequestMapping("/")
    public Result<Notice> Authorize(){

    }

    // 版权音乐
    @RequestMapping("/")
    public void AthuorizeMusic(){

    }

    //登记版权
    @RequestMapping("/")
    public void RecordRegister(){

    }

    // 版权转让
    @RequestMapping("/")
    public void RecordTransfer(){

    }

    // 授权申请
    @RequestMapping("/")
    public void RecordApply(){

    }

    // 版权共享
    @RequestMapping("/")
    public void RecordShare(){

    }


}
