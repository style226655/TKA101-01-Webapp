package com.mem.model;

import java.util.List;

public class MemService {
	
	//宣告有這個介面
	private MemDAO_interface dao;
	
	//留下空建構子，目的給Servlet呼叫
	public MemService() {
	//呼叫具體的實作方法的區域，要new MemDAO()出來
	dao = new MemDAO();
	}
	
	//當Servlet呼叫新增方法，一定要給字串-(String cust_account)
	//將寫入資料庫的資料，會傳到MemVO裡-public MemVO
	public MemVO addMem(String cust_account) {
		//將資料塞給VO
		MemVO memVO = new MemVO();
		memVO.setCust_account(cust_account);
		//把資料給DAO
		dao.insert(memVO);
		//打包好且成功寫入的memVO回傳給Servlet
		return memVO;
	}
	
	public List<MemVO> getAll(){
		return dao.getAll();
	}
}
