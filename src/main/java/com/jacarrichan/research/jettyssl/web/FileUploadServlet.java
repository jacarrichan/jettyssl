package com.jacarrichan.research.jettyssl.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = -2441879968231226756L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		FileUpload fu = new FileUpload();
		fu.setMap(request);// 解析request
		Map<String, FileItem> files = fu.getFiles();
		String fileName = fu.getFileName(files.get("file"));
		String filePath = this.getServletContext().getRealPath(
				"upload\\" )+ fileName;
		System.out.println(filePath);
		File file = new File(filePath);
		try {
			files.get("file").write(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("<script>alert('上传成功！');history.back();</script>");
	}
}
