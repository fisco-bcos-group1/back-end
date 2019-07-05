package org.fisco.bcos.controller;

import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.entity.*;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 用于相应个人中心
 */
@Slf4j
@RestController
public class UserController {

    //@Autowired  private Transfer transfer;


    //String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
    //String privateKey = LoginController.getPrivateKey();
    //Transfer transfer = ContractService.getTransfer(privateKey);

    // 用户信息
    // 可用于企业、音乐人、普通用户
    @RequestMapping("/api/info")
    public Result enterpriseInformation(@RequestBody Map<String,String> request){
        try{
            String privateKey = request.get("privateKey");
            Transfer transfer = ContractService.getTransfer(privateKey);
            User user = transfer.getUser();
            return new Result(1,"用户信息返回成功",user);
        }
        catch (Exception e){
            e.printStackTrace();
            return new Result(0,"用户信息返回失败");
        }
    }





    // 授权订单
    // 显示由我发出的所有Notice
    // 这里的list循坏不知道能不能成功，因为返回的只是list，我并不知道数据的具体类型
    @RequestMapping("/api/orders")
    public Result ShowNoticeStartByMe(@RequestBody Map<String,String> request){
        try{
            String privateKey = request.get("privateKey");
            Transfer transfer = ContractService.getTransfer(privateKey);
            List<Notice> result = new ArrayList<Notice>();
            List<BigInteger> list = transfer.getNoticeNumberByStart();
            int size = list.size();
            for (int i = 0; i<size;++i){
                result.add(transfer.getNotice(list.get(i)));
            }
            log.info(result.toString());
            return new Result(1,"获取所有notice成功",result);
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
    @RequestMapping("/api/musics")
    public Result ShowMuiscOwnedByMe(@RequestBody Map<String,String> request){
        try{
            String privateKey = request.get("privateKey");
            Transfer transfer = ContractService.getTransfer(privateKey);
            List<Music>  result = new ArrayList<Music> ();
            List<BigInteger> list = transfer.getMusicNumber();
            int size = 0;
            size = list.size();
            //String temp = String.valueOf(size);
            //log.info("the size is "+temp);
            for (int i = 0; i<size;++i){
                Music newMusic = transfer.getMusic(list.get(i));
                log.info(newMusic.toString()+ "==============", i);
                result.add(newMusic);
            }
            log.info(result.toString());
            return new Result(1,"获取所有我的音乐成功",result);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"获取所有我的音乐失败");
        }
    }

    /**
     * 应用于版权转让
     *  to 即页面上由用户输入的公钥
     *  bin 记录音乐二进制文件的hash
     *  alltime 所有时间，beg_time # end_time # modified 这里需要拼接
     * @return
     */
    @RequestMapping("/api/transfer")
    public Result RecordTransfer(@RequestBody Map<String,Object> request){
        try{
            String to = (String)request.get("to");
            String bin = (String)request.get("bin");
            String alltime = (String)request.get("alltime");
            String privateKey = (String)request.get("privateKey");
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
     *  bin
     *  alltime
     * @return
     */
    @RequestMapping("/api/cancel")
    public Result CancelMusic(@RequestBody Map<String,Object> request){
        try{
            String bin = (String)request.get("bin");
            String alltime = (String)request.get("alltime");
            String privateKey = (String)request.get("privateKey");
            Transfer transfer = ContractService.getTransfer(privateKey);
            transfer.cancelMusic(bin,alltime);
            return new Result(1,"注销版权成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"注销版权失败");
        }
    }




    //登记版权
    /**
     * 用于响应登记版权
     *  bin 记录音乐二进制文件的hash
     *  mname
     *  alltime 所有时间，beg_time # end_time # modified
     */
    @RequestMapping("/api/publish")
    public Result MusicRegister(@RequestBody Map<String,Object> request){
        try{
            String bin = (String)request.get("bin");
            String mname = (String)request.get("mname");
            String alltime = (String)request.get("alltime");
            String privateKey = (String)request.get("privateKey");
            Transfer transfer = ContractService.getTransfer(privateKey);
            transfer.registerMusic(bin,mname,alltime);
            return new Result(1,"版权登记成功");
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
    @RequestMapping("/api/receiver")
    public Result ShowNotice(@RequestBody Map<String,String> request){
        try{
            String privateKey = request.get("privateKey");
            Transfer transfer = ContractService.getTransfer(privateKey);
            List<Notice> result = new ArrayList<Notice>();
            List<BigInteger> list = transfer.getNoticeNumberByTO();
            int size = list.size();
            for (int i = 0; i<size;++i){
                result.add(transfer.getNotice(list.get(i)));
            }
            log.info(result.toString()+"------------------showNotice");
            return new Result(1,"获取所有Notice成功",result);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"获取所有Notice失败");
        }
    }

    /**
     * 用于点击确定授权
     *  bin
     *  alltime 所有时间，beg_time # end_time # modified 这里需要拼接
     *  to
     *  music
     *  info
     *  numberOfNotice 这个用来消费notice，一定要是BigInteger类型，应该是由网页返回
     * @return
     */
    @RequestMapping("/api/confirm")
    public Result AuthorizeMusic(@RequestBody Map<String,Object> request){
        try{
            String bin = (String)request.get("bin");
            String alltime = (String)request.get("alltime");
            String to = (String)request.get("to");
            String music = (String)request.get("music");
            String info = (String)request.get("info");
            BigInteger numberOfNotice = new BigInteger((String)request.get("NoticeNumber"));
            String privateKey = (String)request.get("privateKey");
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
    @RequestMapping("/api/share")
    public void RecordShare(){

    }


}
