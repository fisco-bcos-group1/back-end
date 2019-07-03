package org.fisco.bcos.service;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.EncryptType;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;

import java.util.ArrayList;
import java.util.List;

/**
 * 随机新建账户，并返回私钥和公钥
 */
public class CreateUser {

    public static List<String> createRomdonUser(){
        List<String> keys = new ArrayList<>();

        //创建普通外部账户
        EncryptType.encryptType = 0;
        //创建国密外部账户，向国密区块链节点发送交易需要使用国密外部账户
        // EncryptType.encryptType = 1;
        Credentials credentials = GenCredential.create();
        //账户地址
        String address = credentials.getAddress();
        //账户私钥
        String privateKey = credentials.getEcKeyPair().getPrivateKey().toString(16);
         //账户公钥
        String publicKey = credentials.getEcKeyPair().getPublicKey().toString(16);

        keys.add(privateKey);
        keys.add(publicKey);
        return keys;
    }
}
