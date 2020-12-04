package invocationhandler;

import cn.pan.api.entity.RpcRequest;
import cn.pan.api.entity.URL;
import cn.pan.register.RegisterType;
import cn.pan.register.factory.RegisterFactory;
import cn.pan.server.protocl.Protocl;
import cn.pan.server.protocl.ProtoclFactory;
import cn.pan.server.protocl.ProtoclType;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RpcInvocationHandler implements InvocationHandler {

    private ProtoclType protoclType;
    private RegisterType registerType;
    private Class interfaceName;

    public RpcInvocationHandler(ProtoclType protoclType, RegisterType registerType, Class interfaceName) {
        this.protoclType = protoclType;
        this.registerType = registerType;
        this.interfaceName = interfaceName;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Protocl protocl = ProtoclFactory.getProtocl(protoclType);
        URL url = RegisterFactory.getRegister(registerType).getURL(interfaceName.getName());
        RpcRequest rpcRequest = new RpcRequest(interfaceName.getName(), method.getName(), args);
        return protocl.invokeProtocl(url, rpcRequest);
    }
}
