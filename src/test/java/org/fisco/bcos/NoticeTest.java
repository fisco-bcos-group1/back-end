package org.fisco.bcos;

import org.fisco.bcos.entity.Music;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.fisco.bcos.service.CreateUser;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class NoticeTest extends BaseTest {
    @Test

    public void Notice() throws Exception {
        List<String> temp = CreateUser.createRomdonUser();
        System.out.println(temp);
        String pk = temp.get(1);


    }
}
