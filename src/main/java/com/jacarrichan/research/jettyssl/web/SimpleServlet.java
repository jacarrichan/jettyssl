package com.jacarrichan.research.jettyssl.web;

import java.io.IOException;

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