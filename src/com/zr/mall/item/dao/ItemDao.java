package com.zr.mall.item.dao;

import com.zr.mall.famework.DruidDbUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDao {
    //查询所有
    private QueryRunner qr =  new QueryRunner(DruidDbUtil.getDataSource());
    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list  = new ArrayList<>();
        String sql = "select * from items";
        try {
            list = qr.query(sql, new MapListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //单个查询
    public Map<String,Object> queryOne(int id){
        String sql = "select * from items where id = ? ";
        try {
            Map<String,Object> map =  qr.query(sql, new MapHandler(),id);
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //添加
      public int  add(Map<String, Object> item){
        String sql = "INSERT INTO db_mall.items (id, name, city, price, number, picture) VALUES (null,?,?,?,?,?)";
        try {
            int i = qr.update(sql, item.get("name"), item.get("city"), item.get("price"), item.get("number"), item.get("picture"));
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //修改

    public int  update(Map<String, Object> item){
        String sql = "update  db_mall.items SET name = ?, city = ?, price = ?, number = ?, picture = ? WHERE id = ?";
        try {
            int i = qr.update(sql, item.get("name"), item.get("city"), item.get("price"), item.get("number"), item.get("picture"));
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //删除

    public int  delete(int id){
        String sql = "delete from  items where id=?";
        try {
            int i = qr.update(sql,id);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }







}
