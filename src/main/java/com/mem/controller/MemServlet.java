package com.mem.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.mem.model.MemService;
import com.mem.model.MemVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
    if ("insert".equals(action)) { // 來自addMem.jsp的請求  
    	
	/***********************1.接收請求參數 - 輸入格式的錯誤處理*********************/
	String account = req.getParameter("account");
	
	/***********************2.開始新增資料***************************************/
	MemService memSvc = new MemService();
	MemVO memVO = memSvc.addMem(account);
			
	/***********************3.新增完成,準備轉交(Send the Success view)***********/
	//把req放進setAttribute指定的地方
	req.setAttribute("memVO", memVO);
	String url = "/admin/member/addMem_success.jsp";
	// 新增成功後轉交指定的URL
	RequestDispatcher successView = req.getRequestDispatcher(url); 
	//確認執行轉交動作
	successView.forward(req, res);				
	}
	}
	}
