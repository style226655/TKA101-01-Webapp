package com.member.model;

import java.util.List;

public interface CustDAO {
	int add(CustVO custVO);
	int update(CustVO custVO);
	int delete(Integer custid);
	CustVO findByPK(Integer custid);
	List<CustVO> getAll();
}
	