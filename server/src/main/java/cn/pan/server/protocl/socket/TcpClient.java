package cn.pan.server.protocl.socket;

import cn.pan.api.entity.RpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TcpClient {

    public <T> T sendRequest(String host, int port, RpcRequest rpcRequest) {
        try {
            System.out.println("创建一个新的连接");
            Socket socket = new Socket(host, port);
            System.out.println("成功连接Rpc服务器，等待结果");
            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rpcRequest);
            outputStream.flush();
            ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
            Object result = inputStream.readObject();
            inputStream.close();
            outputStream.close();
            return (T) result;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
