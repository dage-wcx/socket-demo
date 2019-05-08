package com.socket.utils;

import com.socket.client.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SaveClient
 * @Description
 * @Author wcx
 * @Date 2019/05/05 17:50
 * @Version
 **/
public class SaveClient {

    public static List<Client> list = new ArrayList<Client>();

    public static void add(Client client){
        list.add(client);
    }

    public static List<Client> getList(){
        return list;
    }
}
