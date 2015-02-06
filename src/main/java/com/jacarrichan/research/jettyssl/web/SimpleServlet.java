package com.jacarrichan.research.jettyssl.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleServlet extends HttpServlet {

    private static final long serialVersionUID = -3233466062719235082L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html;charset=UTF-8");// 这条语句指明了向客户端发送的内容格式和采用的字符编码．
        PrintWriter out = resp.getWriter();
        out.println(" HELLO WORLD" + (new Date()));// 利用PrintWriter对象的方法将数据发送给客户端
        out.flush();
        out.close();
        System.out.println("doGet MyServlet");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        System.out.println("doPost MyServlet");
        super.doPost(req, resp);
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("MyServlet");
    }
}