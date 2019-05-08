package com.socket.run;

import com.socket.server.Server2;

/**
 * @ClassName Dage
 * @Description
 * @Author wcx
 * @Date 2019/05/07 16:23
 * @Version
 **/
public class Dage {
    public static void main(String[] args) {
        new Server2("DAGE",8888,10,new byte[]{127,1,1,0}).socket();
    }
}
