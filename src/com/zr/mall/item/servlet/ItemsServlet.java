package com.zr.mall.item.servlet;

import com.zr.mall.item.dao.ItemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/ItemsServlet")
public class ItemsServlet extends HttpServlet {

    private ItemDao dao = new ItemDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("add".equals(method)) {
            add(req, resp);
        } else if ("delete".equals(method)) {
            delete(req, resp);
        } else if ("query".equals(method)) {
            query(req, resp);
        } else if ("update".equals(method)) {
            update(req, resp);
        } else if ("queryOne".equals(method)) {
            queryOne(req, resp);
        }
    }

    //添加数据
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String price = req.getParameter("price");
        String number = req.getParameter("number");
        String picture = req.getParameter("picture");
        //实例化一个map集合，并且将获取的值传入
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("city", city);
        map.put("price", price);
        map.put("number", number);
        map.put("picture", picture);
        int i = dao.add(map);
        resp.sendRedirect(req.getContextPath() + "/ItemsServlet?method=query");
    }

    //删除数据
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        dao.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/ItemsServlet?method=query");
    }

    //修改
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String price = req.getParameter("price");
        String number = req.getParameter("number");
        String picture = req.getParameter("picture");
        //实例化一个map集合，并且将获取的值传入
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("city", city);
        map.put("price", price);
        map.put("number", number);
        map.put("picture", picture);
        int i = dao.update(map);
        resp.sendRedirect(req.getContextPath() + "/ItemsServlet?method=query");

    }

    //查询所有
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, Object>> all = dao.findAll();
        req.setAttribute("all", all);
        req.getRequestDispatcher("query.jsp").forward(req, resp);
    }

    //查询一个
    private void queryOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Map<String, Object> map = dao.queryOne(Integer.parseInt(id));
        req.setAttribute("map", map);
        req.getRequestDispatcher("queryOne.jsp").forward(req, resp);
    }
}
