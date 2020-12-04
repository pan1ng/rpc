package cn.pan.server.protocl.socket;

import cn.pan.api.entity.RpcRequest;
import cn.pan.api.entity.URL;
import cn.pan.server.protocl.Protocl;

public class TcpProtocl implements Protocl {

    @Override
    public Object invokeProtocl(URL url, RpcRequest rpcRequest) {
        TcpClient tcpClient = new TcpClient();
        return tcpClient.sendRequest(url.getHost(), url.getPort(), rpcRequest);
    }

    @Override
    public void start(URL url) {
        RpcServerImpl rpcServer = new RpcServerImpl();
        rpcServer.start(url.getHost(), url.getPort());
    }

}
