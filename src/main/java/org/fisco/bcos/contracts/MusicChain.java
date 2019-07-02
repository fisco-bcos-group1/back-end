package org.fisco.bcos.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
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
    private static final String BINARY = "608060405234801561001057600080fd5b506111f3806100206000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630351bf3d1461007d578063704f1b941461012c5780637dcf16481461019557806385e0c50d146101fe578063b3cbdb3014610287578063ccb018ce14610310575b600080fd5b34801561008957600080fd5b5061012a600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506103f2565b005b34801561013857600080fd5b50610193600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610640565b005b3480156101a157600080fd5b506101fc600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610699565b005b34801561020a57600080fd5b50610285600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610871565b005b34801561029357600080fd5b5061030e600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610c7a565b005b34801561031c57600080fd5b50610377600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610eaf565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156103b757808201518184015260208101905061039c565b50505050905090810190601f1680156103e45780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60008181600201908051906020019061040c92919061109b565b508281600101908051906020019061042592919061109b565b50338160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018160030160006101000a81548160ff021916908315150217905550600181908060018154018082558091505090600182039060005260206000209060080201600090919290919091506000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001820181600101908054600181600116156101000203166002900461054292919061111b565b506002820181600201908054600181600116156101000203166002900461056a92919061111b565b506003820160009054906101000a900460ff168160030160006101000a81548160ff021916908315150217905550600482018160040190805460018160011615610100020316600290046105bf92919061111b565b50600582018160050190805460018160011615610100020316600290046105e792919061111b565b506006820181600601908054600181600116156101000203166002900461060f92919061111b565b506007820181600701908054600181600116156101000203166002900461063792919061111b565b50505050505050565b806000803373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001908051906020019061069592919061109b565b5050565b60008060009150339050600091505b60018054905082101561086c578073ffffffffffffffffffffffffffffffffffffffff166001838154811015156106db57fe5b906000526020600020906008020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480156108205750826040518082805190602001908083835b602083101515610761578051825260208201915060208101905060208303925061073c565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020600019166001838154811015156107a157fe5b9060005260206000209060080201600101604051808280546001816001161561010002031660029004801561080d5780601f106107eb57610100808354040283529182019161080d565b820191906000526020600020905b8154815290600101906020018083116107f9575b5050915050604051809103902060001916145b1561085f57600060018381548110151561083657fe5b906000526020600020906008020160030160006101000a81548160ff0219169083151502179055505b81806001019250506106a8565b505050565b600080600033925060009150600091505b600180549050821015610c7357836040518082805190602001908083835b6020831015156108c557805182526020820191506020810190506020830392506108a0565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390206000191660018381548110151561090557fe5b906000526020600020906008020160010160405180828054600181600116156101000203166002900480156109715780601f1061094f576101008083540402835291820191610971565b820191906000526020600020905b81548152906001019060200180831161095d575b50509150506040518091039020600019161480156109fa57503373ffffffffffffffffffffffffffffffffffffffff166001838154811015156109b057fe5b906000526020600020906008020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b15610c6657338160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550848160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083816002019080519060200190610a9d92919061109b565b50600281908060018154018082558091505090600182039060005260206000209060070201600090919290919091506000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060028201816002019080546001816001161561010002031660029004610bc192919061111b565b5060038201816003019080546001816001161561010002031660029004610be992919061111b565b5060048201816004019080546001816001161561010002031660029004610c1192919061111b565b5060058201816005019080546001816001161561010002031660029004610c3992919061111b565b5060068201816006019080546001816001161561010002031660029004610c6192919061111b565b505050505b8180600101925050610882565b5050505050565b60008033915060009050600090505b600180549050811015610ea957600181815481101515610ca557fe5b906000526020600020906008020160030160009054906101000a900460ff168015610d3b5750600181815481101515610cda57fe5b906000526020600020906008020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16145b8015610e375750826040518082805190602001908083835b602083101515610d785780518252602082019150602081019050602083039250610d53565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902060001916600182815481101515610db857fe5b90600052602060002090600802016001016040518082805460018160011615610100020316600290048015610e245780601f10610e02576101008083540402835291820191610e24565b820191906000526020600020905b815481529060010190602001808311610e10575b5050915050604051809103902060001916145b15610e9c5783600182815481101515610e4c57fe5b906000526020600020906008020160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b8080600101915050610c89565b50505050565b606060008060009150600091505b60018054905082101561109357836040518082805190602001908083835b602083101515610f005780518252602082019150602081019050602083039250610edb565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902060001916600183815481101515610f4057fe5b90600052602060002090600802016001016040518082805460018160011615610100020316600290048015610fac5780601f10610f8a576101008083540402835291820191610fac565b820191906000526020600020905b815481529060010190602001808311610f98575b5050915050604051809103902060001916141561108657600182815481101515610fd257fe5b90600052602060002090600802016002019050808054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561107a5780601f1061104f5761010080835404028352916020019161107a565b820191906000526020600020905b81548152906001019060200180831161105d57829003601f168201915b50505050509250611094565b8180600101925050610ebd565b5b5050919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106110dc57805160ff191683800117855561110a565b8280016001018555821561110a579182015b828111156111095782518255916020019190600101906110ee565b5b50905061111791906111a2565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106111545780548555611191565b8280016001018555821561119157600052602060002091601f016020900482015b82811115611190578254825591600101919060010190611175565b5b50905061119e91906111a2565b5090565b6111c491905b808211156111c05760008160009055506001016111a8565b5090565b905600a165627a7a72305820248eaaafd5e95515e6ba88091b89ae44aba39e5058239ef573831046f1d647010029";

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

    public RemoteCall<TransactionReceipt> consult(String _bin) {
        final Function function = new Function(
                FUNC_CONSULT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_bin)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void consult(String _bin, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CONSULT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_bin)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
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
