package cn.pan.register.local;

import cn.pan.register.LRegister;

import java.util.HashMap;

public class LocalRegister implements LRegister {

    public static HashMap<String , Class> interfaceToImpl = new HashMap<String, Class>();

    @Override
    public void register(String interfaceName, Class interfaceImpl) {
        interfaceToImpl.put(interfaceName, interfaceImpl);
    }

    @Override
    public Class get(String interfaceName) {
        return interfaceToImpl.get(interfaceName);
    }
}
