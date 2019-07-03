package org.fisco.bcos.service;

import org.fisco.bcos.channel.client.Service;
import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.constants.KeyConstants;
import org.fisco.bcos.contracts.MusicChain;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.precompile.permission.PermissionService;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这个暂时没有用，因为在运行前已经部署合约了
 */
public class DeployContract {

    public static String DeployContract() throws Exception{
         MusicChain musicChain;
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
        String privateKey = KeyConstants.PRIVATE_KEY;

        //指定外部账户私钥，用于交易签名
        Credentials credentials = GenCredential.create(privateKey);

        PermissionService permissionService = new PermissionService(web3j,credentials);

        musicChain =
                MusicChain.deploy(
                        web3j,
                        credentials,
                        new StaticGasProvider(
                                GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
                        .send();

        // 返回部署合约地址
        return musicChain.getContractAddress();
        //return musicChain;
    }
}
