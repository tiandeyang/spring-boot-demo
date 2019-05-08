package com.dytian.rpc.order;


import com.dytian.rpc.IProductService;
import org.nutz.json.Json;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class OrderService {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        int prot = 8888;

        ServerSocket serverSocket = new ServerSocket(prot);

        while (true){
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            String className = objectInputStream.readUTF();
            String methodName = objectInputStream.readUTF();
            Class[] paramertyps = (Class[]) objectInputStream.readObject();
            Object[] arggs = (Object[]) objectInputStream.readObject();

            System.out.println(String.format("className===%s---methodName===%s---parameth==",className,methodName, Json.toJson(paramertyps)));

            Class klass = null;
            if (className.equals(IProductService.class.getName())){
                klass = ProductService.class;
            }
            Method method = klass.getMethod(methodName, paramertyps);
            Object invoke = method.invoke(klass.newInstance(), arggs);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(invoke);
            objectOutputStream.flush();

            objectInputStream.close();
            objectOutputStream.close();
        }


    }

}
