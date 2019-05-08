package com.socket.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Message
 * @Description
 * @Author wcx
 * @Date 2019/04/30 09:31
 * @Version
 **/
public class Message implements Serializable {

    /**
     * 消息id
     */
    private Integer msgId;

    /**
     * 客户端端口
     */
    private Integer port;

    /**
     * 发送消息的客户端名称
     */
    private String name;

    /**
     * 接收消息客户端名称
     */
    private String targetName;

    /**
     * 发送的消息内容
     */
    private String msg;

    /**
     * 发送消息的时间
     */
    private String time;

    public Message(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = sdf.format(new Date());
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = sdf.format(time);;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "port=" + port +
                ", name='" + name + '\'' +
                ", targetName=" + targetName +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
