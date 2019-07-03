package org.fisco.bcos.function;

import lombok.Data;
import org.fisco.bcos.channel.client.Service;
import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.MusicChain;
import org.fisco.bcos.entity.Music;
import org.fisco.bcos.entity.Notice;
import org.fisco.bcos.entity.Record;
import org.fisco.bcos.entity.User;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.fisco.bcos.web3j.tuples.generated.Tuple5;
import org.fisco.bcos.web3j.tuples.generated.Tuple6;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.util.List;


// transer function which in the contract into java version

//不太清楚这个data注释有没有用
@Data
public class Transfer {

    //@Autowired private Web3j web3j;
    //@Autowired private Credentials credentials;
    //private String privateKey;
    private static MusicChain musicChain;

    public Transfer(){
    }

    // deploy the contraction
    public void LoadContract(String privateKey,String address) throws Exception{
        // deploy contract

        //读取配置文件，sdk与区块链节点建立连接，获取web3j对象
        //这个配置文件要再调整
        ApplicationContext context = new ClassPathXmlApplicationContext("src/main/resources/application.yml:application.yml");
        Service service = context.getBean(Service.class);
        service.run();
        ChannelEthereumService channelEthereumService = new ChannelEthereumService();
        channelEthereumService.setChannelService(service);
        channelEthereumService.setTimeout(10000);
        Web3j web3j = Web3j.build(channelEthereumService, service.getGroupId());

        // 这个私钥是管理员的私钥，直接内置，无法修改
        //String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";

        //指定外部账户私钥，用于交易签名
        Credentials credentials = GenCredential.create(privateKey);

        //PermissionService permissionService = new PermissionService(web3j,credentials);

        musicChain =
                MusicChain.load(
                        address,
                        web3j,
                        credentials,
                        new StaticGasProvider(
                                GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        //return musicChain;
    }

    // normal user register
    public void registerUser(String name, String phone)throws Exception{
        musicChain.registerUser(name,phone).send();
    }

    // company register
    public void registerCompany(String name, String phone, String id, String location, String email)throws Exception{
        musicChain.registerCompany(name,id,location,phone,email).send();
    }

    // musician register
    public void registerMusician(String name, String phone, String id, String location, String email)throws Exception{
        musicChain.registerMusician(name, id, location, phone, email).send();
    }

    // judge register
    public void registerJudge(String name, String phone, String id, String location, String email)throws Exception{
        musicChain.registerJudge(name, id, location, phone, email).send();
    }

    //music register
    public void registerMusic(String bin, String mname, String alltime) throws Exception{
        musicChain.registerMusic(bin,mname,alltime).send();
    }

    public void cancelMusic(String binhash,String alltime) throws Exception{
        musicChain.cancelMusic(binhash,alltime).send();
    }

    public void registerNotice(String to, String music, String info){
        musicChain.registerNotice(to,music,info);
    }

    public void transferMusic(String to, String binhash, String alltime) throws Exception{
        musicChain.transferMusic(to,binhash,alltime).send();
    }

    public void authorizeMusic(String to, String binhash, String alltime, String music, String info) throws Exception{
        musicChain.authorizeMusic(to,binhash,alltime,music,info).send();
    }


    /*
     分别获取UserEntity中的所有参数

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
    */

    /*
    分别获取Music中的所有参数

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
    */

    /*
    分别获取Record中的所有参数

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

     */

    /*
     分别返回Notice的所有参数
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

     */

    // test only
    public User getUser(){
        User user = new User();
        Tuple6<String, String, String, String, String, String> temp = musicChain.getUser().send();
        user.setName(temp.getValue1());
        user.setType(temp.getValue2());
        user.setId(temp.getValue3());
        user.setLocation(temp.getValue4());
        user.setPhone(temp.getValue5());
        user.setEmail(temp.getValue6());
        return user;
    }

    public Music getMusic(BigInteger number)throws Exception{
        Music music = new Music();
        Tuple6<String, String, String, String, Boolean, String> temp = musicChain.getMusic(number).send();
        music.setOwner(temp.getValue1());
        music.setBin(temp.getValue2());
        music.setmName(temp.getValue3());
        music.setSinger(temp.getValue4());
        music.setValid(temp.getValue5());
        music.setAlltime(temp.getValue6());
        return music;
    }

    public List getMusicNumber(String mname, String singer)throws Exception{
        return musicChain.getMusicNumber(mname,singer).send();
    }

    public Notice getNotice(BigInteger number)throws Exception{
        Notice notice = new Notice();
        Tuple5<String, String, String, String, Boolean> temp = musicChain.getNotice(number).send();
        notice.setStart(temp.getValue1());
        notice.setTo(temp.getValue2());
        notice.setMusic(temp.getValue3());
        notice.setInfo(temp.getValue4());
        notice.setValid(temp.getValue5());
        return notice;
    }

    public List getNoticeNumberByStart(String start)throws Exception{
        return musicChain.getNoticeNumberByStart(start).send();
    }

    public List getNoticeNumberByTO(String to)throws Exception{
        return musicChain.getNoticeNumberByTo(to).send();
    }

    public Record getRecord(BigInteger number)throws Exception{
        Record record = new Record();
        Tuple5<String, String, String, String, String> temp = musicChain.getRecord(number).send();
        record.setUser(temp.getValue1());
        record.setAuthor(temp.getValue2());
        record.setAlltime(temp.getValue3());
        record.setMusic(temp.getValue4());
        record.setInfo(temp.getValue5());
        return record;
    }

    public List getRecordNumber(String user, String author)throws Exception{
        return musicChain.getRecordNumber(user,author).send();
    }

}
