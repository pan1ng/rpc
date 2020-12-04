package cn.pan.register;

import cn.pan.api.entity.URL;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class GetURLThread implements Runnable{

    Socket socket = null;
    InetAddress inetAddress = null;

    public GetURLThread(Socket socket, InetAddress inetAddress){
        this.socket =  socket;
        this.inetAddress = inetAddress;
    }

    @Override
    public void run() {
        System.out.println("成功接收请求，准备推送服务给client");
        try {
            InputStream inputStream = socket.getInputStream();
            byte b [] = new byte[2048];
            int len = inputStream.read(b);
            String interfaceName = new String(b, 0, len);
            if (RegisterCenter.interfaceTable.containsKey(interfaceName)) {
                URL url = (URL)RegisterCenter.interfaceTable.get(interfaceName);
                System.out.println("success find url");
                //返回给client URL
                OutputStream outputStream = socket.getOutputStream();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ObjectOutputStream obout = new ObjectOutputStream(out);
                obout.writeObject(url);
                b = out.toByteArray();
                outputStream.write(b);
                outputStream.flush();
                System.out.println("已回复clientURL");
                outputStream.close();
            } else {
                System.out.println("not find this interface");
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("0".getBytes());
                outputStream.flush();
                outputStream.close();
            }
            inputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
