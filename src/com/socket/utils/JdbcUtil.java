package com.socket.utils;

import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName JdbcUtil
 * @Description
 * @Author wcx
 * @Date 2019/05/08 14:21
 * @Version
 **/
public class JdbcUtil {

    /**
     * 数据库驱动
     */
    private static String driver;

    /**
     * 数据库用户名
     */
    private static String username;

    /**
     * 密码
     */
    private static String password;

    /**
     * 连接路径
     */
    private static String url;

    /**
     *
     */
    private static Properties properties = new Properties();


    static{
        //加载配置文件
        InputStream is = JdbcUtil.class.getResourceAsStream("db.properties");
    }
}
