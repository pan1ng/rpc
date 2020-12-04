package cn.pan.server.protocl.socket;

import cn.pan.api.entity.RpcRequest;
import cn.pan.register.RegisterType;
import cn.pan.register.factory.LocalRegisterFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class RpcHandler implements Runnable{

    private Socket socket;
    private Class service;

    public RpcHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("RPC request accept success！");
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest request = (RpcRequest) inputStream.readObject();
            this.service = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL).get(request.getClassName());
            Object result = invoke(request);
            //返回结果
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest request) throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException, InstantiationException {
        Object[] args = request.getArgs();
        Class<?>[] types = new Class[args.length];
        for(int i = 0; i < args.length; i++){
            types[i] = args[i].getClass();
        }
        Method method = service.getMethod(request.getMethodName(), types);
        return method.invoke(service.newInstance(), args);
    }
}
