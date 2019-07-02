package org.fisco.bcos.function;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.MusicChain;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

// transer function which in the contract into java version

public class Transfer {

    @Autowired private Web3j web3j;
    @Autowired private Credentials credentials;
    private static MusicChain musicChain;

    // deploy the contraction
    public Transfer() throws Exception{
        // deploy contract
        // change the name of contract
        // change the name into MusicChain
        // and change the import
        musicChain =
                MusicChain.deploy(
                        web3j,
                        credentials,
                        new StaticGasProvider(
                                GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
                        .send();
        //return musicChain;
    }


    public void registerUser(String name,String id, String location, String phone, String email) throws Exception{
        //MusicChain musicChain = this.deployContract();
        musicChain.registerUser(name,id,location,phone,email).send();
    }

    public void registerMusic(String bin, String name) throws Exception{
        musicChain.registerMusic(bin,name).send();
    }

    public void cancelMusic(String binhash) throws Exception{
        musicChain.cancelMusic(binhash).send();
    }

    public void registerNotice(String to, String text){
        musicChain.registerNotice(to,text);
    }

    /*
    public static String consult(String bin) throws Exception{
        String result = musicChain.consult(bin).send();
        return result;
    }

     */

    public void transferMusic(String to, String binhash) throws Exception{
        musicChain.transferMusic(to,binhash).send();
    }

    public void authorizeMusic(String to, String binhash) throws Exception{
        musicChain.authorizeMusic(to,binhash).send();
    }

    public String getUserName()throws Exception{
       return musicChain.getUserName().send();
    }

    public static String getUserid()throws Exception{
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
}
