package com.socket.server;

import com.socket.Handler.SessionHandler;
import com.socket.client.Client;
import com.socket.entity.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Server2
 * @Description
 * @Author wcx
 * @Date 2019/04/30 09:41
 * @Version
 **/
public class Server2 {

    /**
     * 服务器名称
     */
    private String serverName;

    /**
     * 服务器端口
     */
    private int port;

    /**
     * socket队列容量
     */
    private int backlog;

    /**
     * 服务器地址
     */
    private byte[] address;

    /**
     * ServerSocket  服务器服务
     */
    private ServerSocket serverSocket;

    /**
     * 获取客户端连接时传递过来的客户端名的流
     */
    private ObjectInputStream ois;

    /**
     * 用来存放已连接的客户端会话
     */
    //private Map<Integer, Socket> clientSocketSession = new HashMap<Integer,Socket>();
    private Map<String, Socket> clientSocketSession = new HashMap<String,Socket>();

    public Server2(String serverName, int port, int backlog, byte[] address) {
        this.serverName = serverName;
        this.port = port;
        this.backlog = backlog;
        this.address = address;
    }

    public void socket(){
        try{
            //创建ServerSocket 绑定端口为8888，ip为127.1.1.0
            serverSocket = new ServerSocket(port,backlog, InetAddress.getByAddress(address));
            System.out.println(serverName +"-->服务器启动，地址信息：" + serverSocket.getLocalSocketAddress() );

            //实现多个客户端连接
            while(true){
                //此方法阻塞  等待客户端连接
                Socket socket = serverSocket.accept();
                ois = new ObjectInputStream(socket.getInputStream());
                String name = (String) ois.readObject();
                //System.out.println("客户端" + socket.getRemoteSocketAddress() + "连接成功");
                System.out.println(name + "-->客户端连接成功，地址信息：" + socket.getRemoteSocketAddress());

                if(socket != null){
                    //将socket放入map，key是客户端端口号
                    //clientSocketSession.put(socket.getPort(),socket);
                    clientSocketSession.put(name,socket);
                    //开启线程处理本次会话
                    Thread thread = new Thread(new SessionHandler(socket,clientSocketSession));
                    thread.setDaemon(true);
                    thread.start();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
