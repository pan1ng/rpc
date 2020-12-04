import cn.pan.api.entity.URL;
import cn.pan.register.RegisterAddress;
import cn.pan.register.RemoteRegister;

public class RegisterTest {
    public static void main(String[] args) {
        URL url = new URL();
        url.setHost("127.0.0.1");
        url.setInterfaceName("cn.pan.api.TestService");
        url.setPort(555);
        RemoteRegister rr = new RemoteRegister();
        rr.register(url);
    }
}
