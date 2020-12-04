package cn.pan.register;

import cn.pan.api.entity.URL;

import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegisterCenter {

    public static Hashtable<String, URL> interfaceTable = new Hashtable<String, URL>();
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        try {
            System.out.println("启动注册线程");
            executorService.execute(new RegisterServer());
            executorService.execute(new GetURLServer());
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
