package org.fisco.bcos.controller;

import org.fisco.bcos.entity.*;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * 用于相应个人中心
 */
@RestController
public class UserController {

    //@Autowired  private Transfer transfer;


    //String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
    //String privateKey = LoginController.getPrivateKey();
    //Transfer transfer = ContractService.getTransfer(privateKey);

    // 用户信息
    // 可用于企业、音乐人、普通用户
    @RequestMapping("/api/11")
    public Result<User> enterpriseInformation(@RequestParam("privateKey") String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            User user = transfer.getUser();
            return new Result<User>(1,"用户信息返回成功",user);
        }
        catch (Exception e){
            e.printStackTrace();
            return new Result(0,"用户信息返回失败");
        }
    }





    // 授权订单
    // 显示由我发出的所有Notice
    // 这里的list循坏不知道能不能成功，因为返回的只是list，我并不知道数据的具体类型
    @RequestMapping("/api/12")
    public Result<List<Notice>> ShowNoticeStartByMe(@RequestParam("privateKey") String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            List<Notice> result = new ArrayList<Notice>();
            List<BigInteger> list = transfer.getNoticeNumberByStart();
            int size = list.size();
            for (int i = 0; i<size;++i){
                result.add(transfer.getNotice(list.get(i)));
            }
            return new Result<List<Notice>>(1,"获取所有notice成功",result);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"获取所有Notice失败");
        }
    }





    // 版权音乐

    /**
     * 显示所有拥有者为我的音乐
     * @return
     */
    @RequestMapping("/api/13")
    public Result<List<Music>> ShowMuiscOwnedByMe(@RequestParam("privateKey") String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            List<Music>  result = new ArrayList<Music> ();
            List<BigInteger> list = transfer.getMusicNumber();
            int size = list.size();
            for (int i = 0; i<size;++i){
                result.add(transfer.getMusic(list.get(i)));
            }
            return new Result<List<Music>>(1,"获取所有我的音乐成功",result);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"获取所有我的音乐失败");
        }
    }

    /**
     * 应用于版权转让
     * @param to 即页面上由用户输入的公钥
     * @param bin 记录音乐二进制文件的hash
     * @param alltime 所有时间，beg_time # end_time # modified 这里需要拼接
     * @return
     */
    @RequestMapping("/api/14")
    public Result RecordTransfer(@RequestParam("to") String to,
                                 @RequestParam("bin") String bin,
                                 @RequestParam("alltime") String alltime,
                                 @RequestParam("privateKey")String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            transfer.transferMusic(to,bin,alltime);
            return new Result(1,"版权转让成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"版权转让失败");
        }

    }

    /**
     * 用于注销音乐版权
     * @param bin
     * @param alltime
     * @return
     */
    @RequestMapping("/api/15")
    public Result CancelMusic(@RequestParam("bin") String bin,
                              @RequestParam("alltime") String alltime,
                              @RequestParam("privateKey")String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            transfer.cancelMusic(bin,alltime);
            return new Result(1,"注销版权成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"版权转让失败");
        }
    }




    //登记版权
    /**
     * 用于响应登记版权
     * @param bin 记录音乐二进制文件的hash
     * @param mname
     * @param alltime 所有时间，beg_time # end_time # modified
     */
    @RequestMapping("/api/16")
    public Result MusicRegister(@RequestParam("bin") String bin,
                                @RequestParam("mname") String mname,
                                @RequestParam("alltime")String alltime,
                                @RequestParam("privateKey")String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            transfer.registerMusic(bin,mname,alltime);
            return new Result(1,"版权登革成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"版权登记失败");
        }
    }




    // 授权申请
    /**
     * 显示所有发给我的Notice，即我是接收者
     * @return
     */
    @RequestMapping("/api/17")
    public Result<List<Notice>> ShowNotice(@RequestParam("privateKey")String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            List<Notice> result = new ArrayList<Notice>();
            List<BigInteger> list = transfer.getNoticeNumberByTO();
            int size = list.size();
            for (int i = 0; i<size;++i){
                result.add(transfer.getNotice(list.get(i)));
            }
            return new Result<List<Notice>>(1,"获取所有notice成功",result);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"获取所有Notice失败");
        }
    }

    /**
     * 用于点击确定授权
     * @param bin
     * @param alltime 所有时间，beg_time # end_time # modified 这里需要拼接
     * @param to
     * @param music
     * @param info
     * @param numberOfNotice 这个用来消费notice，一定要是BigInteger类型，应该是由网页返回
     * @return
     */
    @RequestMapping("/api/18")
    public Result AuthorizeMusic(@RequestParam("bin") String bin,
                                 @RequestParam("alltime") String alltime,
                                 @RequestParam("to") String to,
                                 @RequestParam("music")String music,
                                 @RequestParam("info")String info,
                                 @RequestParam("NoticeNumber") BigInteger numberOfNotice,
                                 @RequestParam("privateKey")String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            transfer.authorizeMusic(to,bin,alltime,music,info);
            transfer.consumeNotice(numberOfNotice);
            return new Result(1,"版权授权成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"版权授权失败");
        }
    }





    // 版权共享
    @RequestMapping("/api/19")
    public void RecordShare(){

    }


}
