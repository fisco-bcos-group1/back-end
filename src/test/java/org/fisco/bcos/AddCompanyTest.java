package org.fisco.bcos;

import org.fisco.bcos.BaseTest;
import org.fisco.bcos.entity.Record;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.junit.Test;

import java.math.BigInteger;

public class AddCompanyTest extends BaseTest {
    @Test

    public void AddCompany() throws Exception {
        String privateKey = "13f57957613347c30785422d42b49fbe1a9f24692ce081822d9c1f5e086423a4";
        Transfer transfer = ContractService.getTransfer(privateKey);
        //transfer.registerUser("zy","110");
        //transfer.registerCompany("zy", "110", "1", "GZ", "a@a.com");
        transfer.registerMusic("07050947","07050947","07050947");
        //Music musictest = transfer.getMusic(number);
        //System.out.println(musictest.getOwner()+ "\n" + musictest.getmName());
        transfer.transferMusic("0x9c1556faed0a2f96dd6d6665e7e76bd9f74d0670","01","2126");
        BigInteger number = new BigInteger("1");
        Record record = transfer.getRecord(number);
        System.out.println(record.toString());
    }
}
