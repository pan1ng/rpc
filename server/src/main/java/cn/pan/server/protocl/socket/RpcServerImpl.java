package cn.pan.server.protocl.socket;

import cn.pan.server.protocl.RpcServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcServerImpl implements RpcServer {

    private ServerSocket serverSocket;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void start(String hostName, Integer port) {
        try {
            System.out.println("开始启动RPC服务器");
            serverSocket = new ServerSocket(port);
            System.out.println("RPC成功启动");
            while(true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new RpcHandler(socket));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
