package com.socket.client;

import com.socket.entity.Message;
import com.socket.utils.SaveClient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName Client1
 * @Description
 * @Author wcx
 * @Date 2019/04/29 15:18
 * @Version
 **/
public class Client {

    /**
     * 客户端名
     */
    private String name;

    /**
     * 客户端对象
     */
    private Socket socket;

    /**
     * 获取服务器转发过来消息的流
     */
    private ObjectInputStream ois;

    /**
     * 连接服务器时，用来传递客户端名到服务器的流
     */
    private ObjectOutputStream os;

    /**
     * 发送消息的流
     */
    private ObjectOutputStream oos;

    public Client(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void scoketStart(){
        try{
            socket = new Socket("127.1.1.0", 8888);
            os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(name);
            System.out.println(name + "-->客户端启动，地址信息：" + socket.getLocalSocketAddress() );

            //接收返回数据
            new Thread(){
                @Override
                public void run(){
                    try{
                        while(true){
                            //获取服务器转发过来的消息
                            ois = new ObjectInputStream(socket.getInputStream());
                            Message msg = (Message) ois.readObject();
                            System.out.println(msg.getTime() + "  " +msg.getName() + "说：" + msg.getMsg());

                        }
                    } catch (Exception e){

                    }
                }
            }.start();

            //发送消息
            oos = new ObjectOutputStream(socket.getOutputStream());
            while(true){
                String msg = new Scanner(System.in).nextLine();
                Message message = new Message();
                message.setPort(socket.getLocalPort());
                System.out.print("输入接收消息的客户端名");
                //int id = new Scanner(System.in).nextInt();
                String targetName = new Scanner(System.in).nextLine();
                //message.setTargetPort(id);
                message.setName(name);
                message.setTargetName(targetName);
                message.setMsg(msg);
                message.setTime(new Date());
                oos.writeObject(message);
                System.out.println("已发送");
            }

        } catch (Exception e){

        } finally {
            //关闭流和连接
            try {
                os.close();
                ois.close();
                oos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
