package cn.pan.server.protocl;

import cn.pan.api.entity.RpcRequest;
import cn.pan.api.entity.URL;

public interface Protocl {

    Object invokeProtocl(URL url, RpcRequest rpcRequest);

    void start(URL url);
}
