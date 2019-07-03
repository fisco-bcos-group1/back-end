package org.fisco.bcos.service;

import org.fisco.bcos.constants.KeyConstants;
import org.fisco.bcos.function.Transfer;

public class ContractService {

    public static Transfer getTransfer(String privateKey) {
        Transfer transfer = new Transfer();
        try{
            //String address = DeployContract.DeployContract();
            //管理员部署的合约地址
            String address = KeyConstants.ADDRESS;
            transfer.LoadContract(privateKey,address);
        }catch (Exception e){
            System.out.println("私钥错误");
            e.printStackTrace();
        }
        return transfer;
    }
}
