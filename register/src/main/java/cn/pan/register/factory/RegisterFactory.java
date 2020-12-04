package cn.pan.register.factory;

import cn.pan.register.Register;
import cn.pan.register.RegisterType;
import cn.pan.register.RemoteRegister;

public class RegisterFactory {

    private static RemoteRegister remoteRegister = new RemoteRegister();
    public static Register getRegister(RegisterType registerType) {
        switch (registerType) {
            case ZOOKEEPER: return null;
            case MYREMOTEREGISTER:
            default: return remoteRegister;
        }
    }
}
