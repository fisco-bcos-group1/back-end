package org.fisco.bcos.function;

import org.fisco.bcos.autoconfigure.Web3jConfig;
import org.fisco.bcos.channel.client.Service;
import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.MusicChain;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;


// transer function which in the contract into java version

public class Transfer {

    //@Autowired private Web3j web3j;
    //@Autowired private Credentials credentials;
    private static MusicChain musicChain;

    // deploy the contraction
    public Transfer(String privateKey) throws Exception{
        // deploy contract

        //读取配置文件，sdk与区块链节点建立连接，获取web3j对象
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Service service = context.getBean(Service.class);
        service.run();
        ChannelEthereumService channelEthereumService = new ChannelEthereumService();
        channelEthereumService.setChannelService(service);
        channelEthereumService.setTimeout(10000);
        Web3j web3j = Web3j.build(channelEthereumService, service.getGroupId());
        //String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
        //指定外部账户私钥，用于交易签名
        Credentials credentials = GenCredential.create(privateKey);

        musicChain =
                MusicChain.deploy(
                        web3j,
                        credentials,
                        new StaticGasProvider(
                                GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
                        .send();
        //return musicChain;
    }


    public void registerUser(String name,String id, String location, String phone, String email) throws Exception{
        //MusicChain musicChain = this.deployContract();
        musicChain.registerUser(name,id,location,phone,email).send();
    }

    public void registerMusic(String bin, String name) throws Exception{
        musicChain.registerMusic(bin,name).send();
    }

    public void cancelMusic(String binhash) throws Exception{
        musicChain.cancelMusic(binhash).send();
    }

    public void registerNotice(String to, String text){
        musicChain.registerNotice(to,text);
    }

    /*
    public static String consult(String bin) throws Exception{
        String result = musicChain.consult(bin).send();
        return result;
    }

     */

    public void transferMusic(String to, String binhash) throws Exception{
        musicChain.transferMusic(to,binhash).send();
    }

    public void authorizeMusic(String to, String binhash) throws Exception{
        musicChain.authorizeMusic(to,binhash).send();
    }

    /**
     * 分别获取UserEntity中的所有参数
     */
    public String getUserName()throws Exception{
       return musicChain.getUserName().send();
    }

    public String getUserid()throws Exception{
        return musicChain.getUserId().send();
    }

    public String getUserLocation() throws Exception{
        return musicChain.getUserLocation().send();
    }

    public String getUserPhone() throws Exception{
        return musicChain.getUserPhone().send();
    }

    public String getUserEmail() throws Exception{
        return musicChain.getUserEmail().send();
    }

    /**
     * 分别获取Music中的所有参数
     */
    public String getMusicOwnerBySearch(String name, String singer) throws Exception{
        return musicChain.getMusicOwnerBySearch(name,singer).send();
    }

    //get music bin by search
    public String getMusicBinBySearch(String name, String singer) throws Exception{
        return musicChain.getMusicBinBySearch(name,singer).send();
    }

    //get music beginning time
    public String getMusicBtimeBySearch(String name, String singer)throws Exception{
        return musicChain.getMusicBtimeBySearch(name,singer).send();
    }

    //get music ending time
    public String getMusicEtimeBySearch(String name, String singer)throws Exception{
        return musicChain.getMusicEtimeBySearch(name,singer).send();
    }

    //get music platform
    public String getMusicPlatormBySearch(String name, String singer)throws Exception{
        return musicChain.getMusicPlatormBySearch(name,singer).send();
    }

    //get music modified time
    public String getMusicModifiedBySearch(String name, String singer)throws Exception{
        return musicChain.getMusicModifiedBySearch(name,singer).send();
    }

    public boolean getMusicIsvalidBySearch(String name, String singer)throws Exception{
        return musicChain.getMusicIsvalidBySearch(name,singer).send();
    }

    /**
     * 分别获取Record中的所有参数
     */

    // 返回所有与该账户有关的recordnumber
    // 这里对list的类型定义不确定
    public List getRecordNumber(String address)throws Exception{
        return musicChain.getRecordNumber(address).send();
    }

    public String getRecordUser(BigInteger num)throws Exception{
        return musicChain.getRecordUser(num).send();
    }

    public String getRecordAuthor(BigInteger num)throws Exception{
        return musicChain.getRecordAuthor(num).send();
    }

    public String getRecordBin(BigInteger num)throws Exception{
        return musicChain.getRecordBin(num).send();
    }

    public String getRecordBTime(BigInteger num)throws Exception{
        return musicChain.getRecordBTime(num).send();
    }

    public String getRecordETime(BigInteger num)throws Exception{
        return musicChain.getRecordETime(num).send();
    }

    public String getRecordPlatform(BigInteger num)throws Exception{
        return musicChain.getRecordPlatform(num).send();
    }

    public String getRecordModified(BigInteger num)throws Exception{
        return musicChain.getRecordModified(num).send();
    }

    /**
     * 分别返回Notice的所有参数
     */
    public List getNoticeNumber(String address)throws Exception{
        return musicChain.getRecordNumber(address).send();
    }

    public String getNoticeFrom(BigInteger num)throws Exception{
        return musicChain.getNoticeFrom(num).send();
    }

    public String getNoticeTo(BigInteger num)throws Exception{
        return musicChain.getNoticeTo(num).send();
    }

    public String getNoticeTime(BigInteger num)throws Exception{
        return musicChain.getNoticeTime(num).send();
    }

    public String getNoticeText(BigInteger num)throws Exception{
        return musicChain.getNoticeText(num).send();
    }

    public boolean getNoticeValid(BigInteger num)throws Exception{
        return musicChain.getNoticeValid(num).send();
    }
}
