package com.cun.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cun.entity.User;
import com.cun.service.UserService;
import com.cun.service.impl.UserServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class Test1
 */
@WebServlet("/Test1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService =new UserServiceImpl();
        // 将JSON字符串作为响应数据返回
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        User userById = userService.getUserById(8);
        Gson gson = new Gson();
        String json = gson.toJson(userById);
        writer.write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
