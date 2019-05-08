package com.socket.server;

import com.sun.security.ntlm.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Server1
 * @Description
 * @Author wcx
 * @Date 2019/04/29 15:30
 * @Version
 **/
public class Server1 extends Thread {

    /**
     * ServerSocket   服务器端服务
     */
    private ServerSocket serverSocket = null;

    /**
     * 用来存放已连接的客户端会话
     */
    private static Map<Integer,Socket> clientSocketSession = new HashMap<Integer, Socket>();

    public Server1(int port, InetAddress address) throws IOException {

        //实例化服务器 并设置该服务器连接端口
        serverSocket = new ServerSocket(port,10,address);

        //设置服务器连接超时时间
        serverSocket.setSoTimeout(100000);
    }

    public void socket() throws IOException {
        int port = Integer.parseInt("8888");
        InetAddress address = InetAddress.getByAddress(new byte[]{127,1,1,1});
        serverSocket = new ServerSocket(port,10,address);
    }

    @Override
    public void run(){
        boolean flag = true;
        System.out.println("服务器启动，服务器地址：" + serverSocket.getLocalSocketAddress());
        try{
            while (true){

                Socket server = serverSocket.accept();

                DataInputStream dis = new DataInputStream(server.getInputStream());
                DataOutputStream dos = new DataOutputStream(server.getOutputStream());
                while (true){
                    System.out.println(server.getRemoteSocketAddress()+ " " +new Date() +":" + dis.readUTF());
                    dos.writeUTF("谢谢连接我：");
                }
            }


        } catch (SocketTimeoutException e){
            flag = false;
            System.out.println("Socket timed out !");
        } catch (IOException e){
            flag = false;
            e.printStackTrace();
        }

    }

    //此方法阻塞，等待客户端的连接    超时没连接报SocketTimeoutException


    public static void main(String[] args) throws UnknownHostException {
        //设置服务器端口
        int port = Integer.parseInt("8888");
        InetAddress address = InetAddress.getByAddress(new byte[]{127,1,1,1});

        try{
            //服务器启动
            Thread t = new Server1(port,address);
            t.run();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
