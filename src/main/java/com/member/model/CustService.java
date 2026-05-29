package com.member.model;

import java.util.List;

public class CustService {
	
	private CustDAO dao;
	
	public CustService() {
		dao = new CustDAOHibernateImpl();
	}
	
	public CustVO addCust(String cust_account) {
		CustVO custVO = new CustVO();
		custVO.setCust_account(cust_account);
		dao.add(custVO);
		return custVO;
	}
}
