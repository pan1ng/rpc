package cn.pan.register;

import cn.pan.api.entity.URL;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class RegisterThread implements Runnable{

    Socket socket = null;
    InetAddress inetAddress = null;

    public RegisterThread(Socket socket, InetAddress inetAddress){
        this.socket =  socket;
        this.inetAddress = inetAddress;
    }

    @Override
    public void run(){
        System.out.println("成功接收服务端服务注册请求");
        try{
            /*InputStream inputStream = socket.getInputStream();
            byte b [] = new byte[2048];
            inputStream.read(b);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(b);
            ObjectInputStream in = new ObjectInputStream(byteIn);
            URL url = (URL)in.readObject();*/
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            URL url = (URL) inputStream.readObject();

            RegisterCenter.interfaceTable.put(url.getInterfaceName(), url);
            //返回
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("success".getBytes());
            outputStream.flush();
            System.out.println("已回复client "+url.getHost());
            inputStream.close();
            outputStream.close();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
