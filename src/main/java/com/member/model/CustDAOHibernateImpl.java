package com.member.model;

import java.util.List;
import org.hibernate.Session;
import Util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustDAOHibernateImpl implements CustDAO{
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Override
	public int add(CustVO custVO) {
		//開始建立交易
		session.beginTransaction();
		session.persist(custVO);
		session.getTransaction().commit();
		return 1;
	}

	@Override
	public int update(CustVO custVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer custid) {
		// TODO Auto-gen;erated method stub
		return 0;
	}

	@Override
	public CustVO findByPK(Integer custid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
