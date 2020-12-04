import cn.pan.api.TestService;
import cn.pan.server.provide.TestServiceImpl;

public class TestServiceImpl_1 {

    public static void main(String[] args) {
        TestService ts = new TestServiceImpl();
        System.out.print(ts.sum(1.6f,5.7f));
        System.out.println(ts.upperCase("aBcDeFgHi"));
    }
}
