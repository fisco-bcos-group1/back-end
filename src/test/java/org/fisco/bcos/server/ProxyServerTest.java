package org.fisco.bcos.server;

import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLException;
import org.fisco.bcos.BaseTest;
import org.fisco.bcos.channel.handler.ChannelConnections;
import org.fisco.bcos.channel.proxy.Server;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ProxyServerTest extends BaseTest {
    @Ignore
    @Test
    public void proxyServerTest() throws SSLException {
        Server server = new Server();
        ChannelConnections channelConnections = new ChannelConnections();
        List<String> ilist = new ArrayList<>();
        ilist.add("101.132.68.46:30901");
        channelConnections.setConnectionsStr(ilist);
        server.setRemoteConnections(channelConnections);

        server.setThreadPool(new ThreadPoolTaskExecutor());
        server.setBindPort(8830);
        server.run();
    }
}
