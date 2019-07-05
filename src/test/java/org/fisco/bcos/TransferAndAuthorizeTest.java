package org.fisco.bcos;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.entity.Music;
import org.fisco.bcos.entity.Record;
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

public class TransferAndAuthorizeTest extends BaseTest {
    @Test

    public void TransferAndAuthorize() throws Exception {
        String privateKey = "13f57957613347c30785422d42b49fbe1a9f24692ce081822d9c1f5e086423a4";
        Transfer transfer = ContractService.getTransfer(privateKey);
        //transfer.registerUser("Dick","911");
        //transfer.registerMusician("Dick", "9527", "HK", "911", "a@a.com");
        transfer.registerMusic("07050947","07050947","07050947");
        //transfer.authorizeMusic("0x10cfdf4da65900e886420517557b1efb01288646", "000008", "xxx","xxx","xxx");
        
        BigInteger number = new BigInteger("9");

        // Test getMusic
        //Music music0 = transfer.getMusic(number);

        // Test getMusicNumber
        //List result = transfer.getMusicNumber();
        //System.out.println(music0.getOwner());
        //transfer.transferMusic("0x9c1556faed0a2f96dd6d6665e7e76bd9f74d0670", "000003", "newalltime4");
        //BigInteger number = new BigInteger("1");
        //Record record = transfer.getRecord(number);
        //System.out.println(record.toString());
        //System.out.println(music0.getOwner());
        //assertTrue("bin1".equals(music0.getBin()));
        //System.out.println(temp);
        Music musictest = transfer.getMusic(number);
        System.out.println(musictest.getOwner()+ "\n" + musictest.getmName());
        transfer.transferMusic("0x9c1556faed0a2f96dd6d6665e7e76bd9f74d0670", "07050947", "07050947");
        System.out.println(musictest.getOwner()+ "\n" + musictest.getmName());
    }
}
