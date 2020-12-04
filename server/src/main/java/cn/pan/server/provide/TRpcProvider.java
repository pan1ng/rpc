package cn.pan.server.provide;

import cn.pan.api.TestService;
import cn.pan.api.entity.URL;
import cn.pan.register.LRegister;
import cn.pan.register.Register;
import cn.pan.register.RegisterType;
import cn.pan.register.factory.LocalRegisterFactory;
import cn.pan.register.factory.RegisterFactory;
import cn.pan.server.protocl.Protocl;
import cn.pan.server.protocl.ProtoclFactory;
import cn.pan.server.protocl.ProtoclType;

public class TRpcProvider {

    public static void main(String[] args) {

        URL url = new URL(TestService.class.getName(), "localhost", 3456);

        Register register = RegisterFactory.getRegister(RegisterType.MYREMOTEREGISTER);
        register.register(url);
        LRegister lRegister = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL);
        lRegister.register(TestService.class.getName(), TestServiceImpl.class);

        Protocl protocl = ProtoclFactory.getProtocl(ProtoclType.TCP);
        protocl.start(url);
    }
}
