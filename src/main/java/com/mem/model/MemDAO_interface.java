package com.mem.model;

import java.util.List;

//定義合約，為了給service呼叫用
	public interface MemDAO_interface{
		//新增
		public void insert(MemVO memVO);
		//修改
		public void update(MemVO memVO);
		//刪除
		public void delete(MemVO memVO);
		
		//查詢全部的資料別表
		public MemVO findByPrimaryKey(Integer cust_id);
		public List<MemVO> getAll();
		
	}
