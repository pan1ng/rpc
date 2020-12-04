package cn.pan.register;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegisterServer implements Runnable{

    ServerSocket serverSocket;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void run() {
        try {
            System.out.println("启动注册socket");
            serverSocket = new ServerSocket(RegisterAddress.registerPort);
            System.out.println("socket启动成功");
            while(true) {
                Socket socket = serverSocket.accept();
                InetAddress inetAddress = socket.getInetAddress();
                executorService.execute(new RegisterThread(socket, inetAddress));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
