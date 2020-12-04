import cn.pan.api.entity.URL;
import cn.pan.register.RemoteRegister;

public class GetURLTest {
    public static void main(String[] args) {
        String interfaceName = "cn.pan.api.TestService";
        RemoteRegister remoteRegister = new RemoteRegister();
        URL url = remoteRegister.getURL(interfaceName);
        if (url == null) {
            System.out.println(interfaceName + " is not find in the register-center");
        } else {
            System.out.println(url.getHost() + url.getInterfaceName() + url.getPort() + url.getClass());
        }
    }
}
