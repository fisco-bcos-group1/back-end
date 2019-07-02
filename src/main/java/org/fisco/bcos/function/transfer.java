package org.fisco.bcos.function;

import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.MusicChain;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;

// transer function which in the contract into java version
public class transfer {

    @Autowired private Web3j web3j;
    @Autowired private Credentials credentials;
    private static MusicChain musicChain;

    // deploy the contraction
    public void deployContract() throws Exception{
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

    public void registerUser(String name) throws Exception{
        //MusicChain musicChain = this.deployContract();
        musicChain.registerUser(name).send();
    }

    public void registerMusic(String bin, String name) throws Exception{
        musicChain.registerMusic(bin,name).send();
    }

    public void cancelMusic(String binhash) throws Exception{
        musicChain.cancelMusic(binhash).send();
    }

    public String consult(String bin) throws Exception{
        String result = musicChain.consult(bin).send();
        return result;
    }

    public void transferMusic(String to, String binhash) throws Exception{
        musicChain.transferMusic(to,binhash).send();
    }

    public void authorizeMusic(String to, String binhash) throws Exception{
        musicChain.authorizeMusic(to,binhash).send();
    }
}
