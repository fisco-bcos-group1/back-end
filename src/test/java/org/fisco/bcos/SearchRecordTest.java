package org.fisco.bcos;

import org.fisco.bcos.BaseTest;
import org.fisco.bcos.entity.Music;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.junit.Test;

import java.math.BigInteger;

public class SearchRecordTest extends BaseTest {
    @Test

    public void SearchRecord() throws Exception {
        String privateKey = "db776e77d3f18f7481d099a844675c77858b53ca8a015df2ba07bcc0608d76cf";
        Transfer transfer = ContractService.getTransfer(privateKey);
        //transfer.registerUser("John","911");
        //transfer.registerMusician("John", "9527", "HK", "911", "a@a.com");
        BigInteger number = new BigInteger("8");
        Music musictest = transfer.getMusic(number);
        System.out.println(musictest.getOwner()+ musictest.getmName());
        }

}
