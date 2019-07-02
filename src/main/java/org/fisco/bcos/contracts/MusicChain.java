package org.fisco.bcos.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class MusicChain extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50611188806100206000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630351bf3d1461007d578063704f1b941461012c5780637dcf16481461019557806385e0c50d146101fe578063b3cbdb3014610287578063ccb018ce14610310575b600080fd5b34801561008957600080fd5b5061012a600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506103f2565b005b34801561013857600080fd5b50610193600480360381019080803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506105cf565b005b3480156101a157600080fd5b506101fc600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610628565b005b34801561020a57600080fd5b50610285600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506107c2565b005b34801561029357600080fd5b5061030e600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610bcb565b005b34801561031c57600080fd5b50610377600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610dca565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156103b757808201518184015260208101905061039c565b50505050905090810190601f1680156103e45780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6001610100604051908101604052803373ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200160001515815260200160206040519081016040528060008152508152602001602060405190810160405280600081525081526020016020604051908101604052806000815250815260200160206040519081016040528060008152508152509080600181540180825580915050906001820390600052602060002090600802016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001019080519060200190610516929190610fb0565b506040820151816002019080519060200190610533929190610fb0565b5060608201518160030160006101000a81548160ff0219169083151502179055506080820151816004019080519060200190610570929190610fb0565b5060a082015181600501908051906020019061058d929190610fb0565b5060c08201518160060190805190602001906105aa929190610fb0565b5060e08201518160070190805190602001906105c7929190610fb0565b505050505050565b806000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000019080519060200190610624929190611030565b5050565b60008060009150339050600091505b6001805490508210156107bd578073ffffffffffffffffffffffffffffffffffffffff1660018381548110151561066a57fe5b906000526020600020906008020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480156107af5750826040518082805190602001908083835b6020831015156106f057805182526020820191506020810190506020830392506106cb565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390206000191660018381548110151561073057fe5b9060005260206000209060080201600101604051808280546001816001161561010002031660029004801561079c5780601f1061077a57610100808354040283529182019161079c565b820191906000526020600020905b815481529060010190602001808311610788575b5050915050604051809103902060001916145b508180600101925050610637565b505050565b600080600033925060009150600091505b600180549050821015610bc457836040518082805190602001908083835b60208310151561081657805182526020820191506020810190506020830392506107f1565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390206000191660018381548110151561085657fe5b906000526020600020906008020160010160405180828054600181600116156101000203166002900480156108c25780601f106108a05761010080835404028352918201916108c2565b820191906000526020600020905b8154815290600101906020018083116108ae575b505091505060405180910390206000191614801561094b57503373ffffffffffffffffffffffffffffffffffffffff1660018381548110151561090157fe5b906000526020600020906008020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b15610bb757338160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550848160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550838160020190805190602001906109ee929190611030565b50600281908060018154018082558091505090600182039060005260206000209060070201600090919290919091506000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060028201816002019080546001816001161561010002031660029004610b129291906110b0565b5060038201816003019080546001816001161561010002031660029004610b3a9291906110b0565b5060048201816004019080546001816001161561010002031660029004610b629291906110b0565b5060058201816005019080546001816001161561010002031660029004610b8a9291906110b0565b5060068201816006019080546001816001161561010002031660029004610bb29291906110b0565b505050505b81806001019250506107d3565b5050505050565b60008033915060009050600090505b600180549050811015610dc457600181815481101515610bf657fe5b906000526020600020906008020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16148015610d525750826040518082805190602001908083835b602083101515610c935780518252602082019150602081019050602083039250610c6e565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902060001916600182815481101515610cd357fe5b90600052602060002090600802016001016040518082805460018160011615610100020316600290048015610d3f5780601f10610d1d576101008083540402835291820191610d3f565b820191906000526020600020905b815481529060010190602001808311610d2b575b5050915050604051809103902060001916145b15610db75783600182815481101515610d6757fe5b906000526020600020906008020160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b8080600101915050610bda565b50505050565b60606000809050600090505b600180549050811015610fa957826040518082805190602001908083835b602083101515610e195780518252602082019150602081019050602083039250610df4565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902060001916600182815481101515610e5957fe5b90600052602060002090600802016001016040518082805460018160011615610100020316600290048015610ec55780601f10610ea3576101008083540402835291820191610ec5565b820191906000526020600020905b815481529060010190602001808311610eb1575b50509150506040518091039020600019161415610f9c57600181815481101515610eeb57fe5b90600052602060002090600802016002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f905780601f10610f6557610100808354040283529160200191610f90565b820191906000526020600020905b815481529060010190602001808311610f7357829003601f168201915b50505050509150610faa565b8080600101915050610dd6565b5b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610ff157805160ff191683800117855561101f565b8280016001018555821561101f579182015b8281111561101e578251825591602001919060010190611003565b5b50905061102c9190611137565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061107157805160ff191683800117855561109f565b8280016001018555821561109f579182015b8281111561109e578251825591602001919060010190611083565b5b5090506110ac9190611137565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106110e95780548555611126565b8280016001018555821561112657600052602060002091601f016020900482015b8281111561112557825482559160010191906001019061110a565b5b5090506111339190611137565b5090565b61115991905b8082111561115557600081600090555060010161113d565b5090565b905600a165627a7a723058208a2203f05f52532f3666e92cff9a9aead240806bc1f5ec11dd69d68c98495f120029";

    public static final String FUNC_REGISTERMUSIC = "registerMusic";

    public static final String FUNC_REGISTERUSER = "registerUser";

    public static final String FUNC_CANCELMUSIC = "cancelMusic";

    public static final String FUNC_AUTHORIZEMUSIC = "authorizeMusic";

    public static final String FUNC_TRANSFERMUSIC = "transferMusic";

    public static final String FUNC_CONSULT = "consult";

    @Deprecated
    protected MusicChain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MusicChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MusicChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MusicChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> registerMusic(String _bin, String _name) {
        final Function function = new Function(
                FUNC_REGISTERMUSIC, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_bin), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void registerMusic(String _bin, String _name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REGISTERMUSIC, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_bin), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> registerUser(String _name) {
        final Function function = new Function(
                FUNC_REGISTERUSER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void registerUser(String _name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REGISTERUSER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> cancelMusic(String _binhash) {
        final Function function = new Function(
                FUNC_CANCELMUSIC, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_binhash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void cancelMusic(String _binhash, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CANCELMUSIC, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_binhash)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> authorizeMusic(String _to, String _binhash) {
        final Function function = new Function(
                FUNC_AUTHORIZEMUSIC, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_to), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_binhash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void authorizeMusic(String _to, String _binhash, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_AUTHORIZEMUSIC, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_to), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_binhash)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> transferMusic(String _to, String _binhash) {
        final Function function = new Function(
                FUNC_TRANSFERMUSIC, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_to), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_binhash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void transferMusic(String _to, String _binhash, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_TRANSFERMUSIC, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_to), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_binhash)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<String> consult(String _bin) {
        final Function function = new Function(FUNC_CONSULT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_bin)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static MusicChain load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MusicChain(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MusicChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MusicChain(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MusicChain load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MusicChain(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MusicChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MusicChain(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MusicChain> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MusicChain.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MusicChain> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MusicChain.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MusicChain> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MusicChain.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MusicChain> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MusicChain.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
