package org.fisco.bcos;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.entity.Music;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.fisco.bcos.service.CreateUser;
import org.fisco.bcos.temp.HelloWorld;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;

import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MusicTest extends BaseTest {
    @Test

    public void RigisterAndGetMusic() throws Exception {
        String privateKey = "a3cffe5e24835dd88858bdd1460903c431579d9e5da6dccc45742beb9c103b54";
        Transfer transfer = ContractService.getTransfer(privateKey);
        transfer.registerMusic("bin1","mnane1","alltime1");
        transfer.registerMusic("bin2","2","alltime2");
        BigInteger number = new BigInteger("0");

        // Test getMusic
        Music music0 = transfer.getMusic(number);

        // Test getMusicNumber
        List result = transfer.getMusicNumber();
        System.out.println(result);
        assertTrue("bin1".equals(music0.getBin()));
        //System.out.println(temp);
    }
}
