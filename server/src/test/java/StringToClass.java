import cn.pan.api.*;
import cn.pan.server.provide.TestServiceImpl;

public class StringToClass {

    public static void main(String[] args) {
        TestService testService = new TestServiceImpl();
        System.out.println(testService.getClass());
        System.out.println(TestService.class.toString());
    }
}
