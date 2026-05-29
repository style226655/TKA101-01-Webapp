package com.member.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.member.model.CustService;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustServlet")
public class CustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//http連線前端的doGet,doPost
	public void doGet (HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost (HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
	//設定前端傳過來的文字編碼，不會抓到變形的中文字
	req.setCharacterEncoding("UTF-8");
	//檢查前端用哪一種動作
	String action = req.getParameter("action");
	
	
	//新增會員功能，跟前端網頁串連
	if("insert".equals(action)) {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
		
		/***********************1.接收請求參數	 *************************/
											//前端變數要是account
		String custAccount = req.getParameter("account");
		if (custAccount == null || custAccount.trim().length() == 0) {
			req.setAttribute("msg","請勿空白");
			req.getRequestDispatcher("/admin/member/addCust.jsp").forward(req, res);
            return;
        }
		/***************************2.開始新增資料***************************************/
		CustService custSvc = new CustService();
		custSvc.addCust(custAccount);
		
		/***************************3.新增完成,準備轉交(Send the Success view)***********/
		String url = "/admin/member/addCust.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
		successView.forward(req, res);			
	}
	}
}