package comsumer;

import cn.pan.api.TestService;
import cn.pan.register.RegisterType;
import cn.pan.server.protocl.ProtoclType;
import proxy.ProxyFactory;

public class TComsumer {

    public static void main(String[] args) {
        TestService testService = ProxyFactory.getProxy(ProtoclType.TCP, RegisterType.MYREMOTEREGISTER, TestService.class);
        System.out.println(testService.upperCase("aBcDeFgHiJklmnopq"));
        System.out.println(testService.sum(1.5f, 1.6f));
    }
}
