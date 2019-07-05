package org.fisco.bcos;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.entity.Music;
import org.fisco.bcos.entity.Notice;
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

public class AddUserTest extends BaseTest {
    @Test

    public void AddUser() throws Exception {
        String privateKey = "6f0c5ae59e46cf3413e4b7f2152f2e32dd56cbda3fc5902fc651a8bbac8e8140";
        Transfer transfer = ContractService.getTransfer(privateKey);
        //transfer.registerUser("kobe","911");
        //transfer.registerMusician("ZY", "9527", "HK", "911", "a@a.com");
        //transfer.registerMusic("000008","music2","alltime2");
        //tranfer.authorizeMusic("0x10cfdf4da65900e886420517557b1efb01288646", "000008", "xxx","xxx","xxx");
        /*
        BigInteger number = new BigInteger("2");

        // Test getMusic
        Music music0 = transfer.getMusic(number);

        // Test getMusicNumber
        //List result = transfer.getMusicNumber();
        System.out.println(music0.getOwner());
        transfer.transferMusic("0x10cfdf4da65900e886420517557b1efb01288646", "000008", "newalltime2");
        System.out.println(music0.getOwner());
        //assertTrue("bin1".equals(music0.getBin()));
        //System.out.println(temp);

         */
        //Music music = transfer.searchMusic("music2","kobe");
        BigInteger number = new BigInteger("0");
        Notice notice = transfer.getNotice(number);
        System.out.println(notice.toString());
    }
}
