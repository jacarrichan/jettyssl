package com.jacarrichan.research.jettyssl.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FileUploadStatus extends HttpServlet {

	private static final long serialVersionUID = -2441879968231226756L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String status = (String) session.getAttribute("read");// 获取上传进度百分比
		System.out.println(status + "FileUploadStatus");
		out.println(status);// 响应
	}
}
