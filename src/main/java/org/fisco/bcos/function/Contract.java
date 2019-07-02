package org.fisco.bcos.function;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.solidity.compiler.CompilationResult;
import org.fisco.bcos.web3j.solidity.compiler.SolidityCompiler;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.fisco.bcos.web3j.solidity.compiler.SolidityCompiler.Options.*;
import static org.fisco.bcos.web3j.solidity.compiler.SolidityCompiler.Options.METADATA;

import org.fisco.bcos.contracts.MusicChain;


@Slf4j
public class Contract {

    @Autowired private Web3j web3j;
    @Autowired private Credentials credentials;

    public MusicChain deployContract() throws Exception{
        // deploy contract
        // change the name of contract
        // change the name into MusicChain
        // and change the import
        MusicChain musicChain =
                MusicChain.deploy(
                        web3j,
                        credentials,
                        new StaticGasProvider(
                                GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
                        .send();
        return musicChain;
    }

    //transfer solidity into java
    public void compileSolFilesToJavaTest() throws IOException {
        File solFileList = new File("src/test/resources/contract");
        File[] solFiles = solFileList.listFiles();

        for (File solFile : solFiles) {

            SolidityCompiler.Result res = SolidityCompiler.compile(solFile, true, ABI, BIN, INTERFACE, METADATA);
            log.info("Out: '{}'" , res.output );
            log.info("Err: '{}'" , res.errors );
            CompilationResult result = CompilationResult.parse(res.output);
            log.info("contractname  {}" , solFile.getName());
            String contractname = solFile.getName().split("\\.")[0];
            CompilationResult.ContractMetadata a = result.getContract(solFile.getName().split("\\.")[0]);
            log.info("abi   {}" , a.abi);
            log.info("bin   {}" , a.bin);
            FileUtils.writeStringToFile(new File("src/test/resources/solidity/" + contractname + ".abi"), a.abi);
            FileUtils.writeStringToFile(new File("src/test/resources/solidity/" + contractname + ".bin"), a.bin);
            String binFile;
            String abiFile;
            String tempDirPath = new File("src/test/java/").getAbsolutePath();
            String packageName = "org.fisco.bcos.temp";
            String filename = contractname;
            abiFile = "src/test/resources/solidity/" + filename + ".abi";
            binFile = "src/test/resources/solidity/" + filename + ".bin";
            SolidityFunctionWrapperGenerator.main(Arrays.asList(
                    "-a", abiFile,
                    "-b", binFile,
                    "-p", packageName,
                    "-o", tempDirPath
            ).toArray(new String[0]));
        }
        System.out.println("generate successfully");
    }
}
