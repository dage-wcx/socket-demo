package com.socket.Handler;

import com.socket.entity.Message;

import java.io.*;
import java.net.Socket;
import java.util.Map;

/**
 * @ClassName SessionHandler
 * @Description
 * @Author wcx
 * @Date 2019/04/30 09:51
 * @Version
 **/
public class SessionHandler extends Thread {

    /**
     * 客户端
     */
    private Socket socket;

    /**
     * 客户端输入流
     */
    private InputStream in;


    //private Map<Integer,Socket> clientSocketSession = null;
    private Map<String,Socket> clientSocketSession = null;

    /*public SessionHandler(Socket socket, Map<Integer, Socket> clientSocketSession) {
        this.socket = socket;
        this.clientSocketSession = clientSocketSession;
    }*/
    public SessionHandler(Socket socket, Map<String, Socket> clientSocketSession) {
        this.socket = socket;
        this.clientSocketSession = clientSocketSession;
    }

    @Override
    public void run(){
        try{
            in = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);

            //实现一次连接多次通话
            while(true){
                try{
                    Message msg = (Message) ois.readObject();
                    System.out.println(msg);

                    //发送数据
                    Socket targetSocket =  clientSocketSession.get(msg.getTargetName());
                    if(targetSocket == null || targetSocket.isClosed()){
                        System.out.println(msg.getTargetName()+"不再线");
                        continue;
                    }
                    OutputStream out = targetSocket.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                    oos.writeObject(msg);
                    System.out.println("服务端已转发");

                    if(socket.isClosed()){
                        break;
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                    socket.close();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
