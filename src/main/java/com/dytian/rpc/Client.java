package com.dytian.rpc;

import org.nutz.json.Json;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Client {


    public static void main(String[] args) {

        IProductService rpc = (IProductService) rpc(IProductService.class);
        Product productById = rpc.findProductById(100);
        System.out.println(Json.toJson(productById));
        
    }


    public static Object rpc(final Class<?> klass){

       return Proxy.newProxyInstance(klass.getClassLoader(), new Class[]{klass}, new InvocationHandler() {

            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {

                Socket socket = new Socket("127.0.0.1",8888);

                String name = method.getName();
                String classNmae = klass.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();

                System.out.println(String.format("className==%s---methodName===%s---parainType===%s",classNmae,name,Json.toJson(parameterTypes)));
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(classNmae);
                objectOutputStream.writeUTF(name);
                objectOutputStream.writeObject(parameterTypes);
                objectOutputStream.writeObject(args);
                objectOutputStream.flush();

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Object result = objectInputStream.readObject();

                objectOutputStream.close();
                objectInputStream.close();
                return result;

            }
        });


    }

}
