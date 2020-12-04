package cn.pan.register.factory;

import cn.pan.register.LRegister;
import cn.pan.register.RegisterType;
import cn.pan.register.local.LocalRegister;

public class LocalRegisterFactory {

    private static LocalRegister localRegister = new LocalRegister();
    public static LRegister getLocalRegister(RegisterType registerType){
        switch (registerType){
            case LOCAL: return localRegister;
            default:return null;
        }
    }
}
