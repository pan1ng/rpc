package cn.pan.register;

public interface LRegister {

    void register(String interfaceName,Class interfaceImpl);

    Class get(String interfaceName);
}
