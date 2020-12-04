package proxy;

import cn.pan.register.RegisterType;
import cn.pan.server.protocl.ProtoclType;
import invocationhandler.RpcInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    /**
     * 根据通信协议类型， 注册中心实现方式 以及 接口类来获取代理
     * @param protoclType
     * @param registerType
     * @param interfaceName
     * @param <T>
     * @return
     */
    public static <T> T getProxy(final ProtoclType protoclType,
                                 final RegisterType registerType,
                                 final Class interfaceName) {
        return (T) Proxy.newProxyInstance(interfaceName.getClassLoader(), new Class[] {interfaceName},
                new RpcInvocationHandler(protoclType, registerType, interfaceName));
    }
}
