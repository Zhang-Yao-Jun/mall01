package com.zr.mall.famework;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DruidDbUtil {
        private static Properties properties = new Properties();
        static{
            InputStream in = DruidDbUtil.class.getClassLoader().getResourceAsStream("db.properties");
            try {
                properties.load(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static Connection getConnection() {
        Connection connection = null;
            try {
                DataSource ds = getDataSource();
                connection  = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
    }

    public static DataSource getDataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.configFromPropety(properties);
        return ds;
    }

    //关闭的方法
    public static void close(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
