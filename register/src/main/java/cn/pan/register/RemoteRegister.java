package cn.pan.register;

import cn.pan.api.entity.URL;

import java.io.*;

import java.net.Socket;

public class RemoteRegister implements Register{

    public void register(URL host) {
        try {
            Socket socket = new Socket(RegisterAddress.centerHost, RegisterAddress.registerPort);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obout = new ObjectOutputStream(out);
            obout.writeObject(host);
            byte b[] = new byte[2048];
            b = out.toByteArray();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(b);
            outputStream.flush();
            //接收返回
            InputStream inputStream = socket.getInputStream();
            byte res[] = new byte[2048];
            Integer len = inputStream.read(res);
            if (new String(res, 0, len).equals("success")) {
                System.out.println("REGISTER SUCCESS");
            }
            inputStream.close();
            outputStream.close();
            socket.close();
            System.out.println("注册结束");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public URL getURL(String interfaceName) {
        URL url = null;
        try {
            Socket socket = new Socket(RegisterAddress.centerHost, RegisterAddress.getURLPort);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(interfaceName.getBytes());
            outputStream.flush();
            //接收返回
            InputStream inputStream = socket.getInputStream();
            byte b [] = new byte[2048];
            Integer len = inputStream.read(b);
            if (new String(b, 0, len).equals("0")) {
                return null;
            }
            inputStream.read(b);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(b);
            ObjectInputStream in = new ObjectInputStream(byteIn);
            url = (URL)in.readObject();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return url;
    }
}
