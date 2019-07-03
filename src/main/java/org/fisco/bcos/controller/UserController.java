package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Notice;
import org.fisco.bcos.entity.Record;
import org.fisco.bcos.entity.Result;
import org.fisco.bcos.entity.User;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;


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
        }
        catch (Exception e){
            e.printStackTrace();
            return new Result(0,"用户信息返回失败");
        }
    }


    // 授权订单
    @RequestMapping("/")
    public Result<List<Notice>> Authorize(){
        try{
            List list = transfer.getNoticeNumberByStart("delete tommor");
        }catch (Exception e){
            e.printStackTrace();
            return Result(0,"查询授权订单失败");
        }

    }

    // 版权音乐
    @RequestMapping("/")
    public void AthuorizeMusic(){

    }

    /**
     * 用于响应登记版权
     * @param bin 记录音乐二进制文件的hash
     * @param mname
     * @param alltime 所有时间，beg_time # end_time # modified
     */
    //登记版权
    @RequestMapping("/")
    public Result RecordRegister(@RequestParam("bin") String bin,
                               @RequestParam("mname") String mname,
                               @RequestParam("alltime")String alltime){
        try{
            transfer.registerMusic(bin,mname,alltime);
            return new Result(1,"版权登革成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"版权登记失败")；
        }
    }

    // 版权转让
    @RequestMapping("/")
    public void RecordTransfer(){

    }

    // 授权申请
    @RequestMapping("/")
    public void RecordApply(){
        try{
            List<BigInteger> list = transfer.getNoticeNumberByTO("delete tommorrow");
        }
    }

    // 版权共享
    @RequestMapping("/")
    public void RecordShare(){

    }


}
