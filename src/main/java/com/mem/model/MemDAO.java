package com.mem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//給出在interface裡，合約中所有方法的SQL
public class MemDAO implements MemDAO_interface{
	
	//JNDI初始化連線池
	private static DataSource ds = null;
	//靜態初始化區塊
	//(第一次被載入記憶體時，這段程式碼會「自動執行一次」，且一輩子只執行這一次)
	static {
		try {
			//打開Tomcat伺服器的「官方通訊錄（目錄服務）」
			Context ctx = new InitialContext();
			//lookup()：就是在通訊錄裡搜尋
			//"java:comp/env/"：固定字串，代表去Tomcat的環境找東西
			//"jdbc/TestDB2"：對應到Tomcat的context.xml裡面的<Resource name="jdbc/TestDB2" ...>
			//(DataSource)：搜尋出來的結果是萬物之源Object，所以必須用強迫轉型，把它轉成連線池DataSource
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myMemberDB");
			}catch(NamingException e) {
				e.printStackTrace();
			}
	}
	
	//實作SQL語法
	private static final String INSERT_STMT = "INSERT INTO customer (CUST_ACCOUNT) values(?)";	
	private static final String GET_ALL_STMT = "SELECT CUST_ID,CUST_ACCOUNT,CUST_PASSWORD FROM CUSTOMER";	
	
	@Override
	public void insert(MemVO memVO) {
		//宣告空箱子(呼叫連線、準備拿取連線)
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//跟連線池要一條連線(不用再自己新建連線)
			con = ds.getConnection();
			//把SQL語法塞給這個連線
			pstmt = con.prepareStatement(INSERT_STMT);
			//對應JDBC的(第一個問號，呼叫memVO裡的getCust_account方法)
			pstmt.setString(1, memVO.getCust_account());
			//送出SQL語法執行
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("資料庫錯誤發生"+se.getMessage());
			}
		
		//關閉連線，先關資料庫，再關連線
		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	@Override
	public List<MemVO> getAll() {
		List<MemVO> list = new ArrayList<MemVO>();
		MemVO memVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
		while(rs.next()) {
			memVO = new MemVO();
			memVO.setCust_id(rs.getInt("cust_id"));
			memVO.setCust_account(rs.getString("cust_account"));
			memVO.setCust_password(rs.getString("cust_password"));
			list.add(memVO);
		}	
		//資料庫錯誤的處理
		}catch(SQLException se) {
			throw new RuntimeException("資料庫錯誤發生"
			+ se.getMessage());
		//rs,pstmt,con連線依序關閉	
		} finally {
			if (rs != null) {
				try {
					rs.close();
				}catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try{
					pstmt.close();
				}catch(SQLException se){
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
		
		
		
	}
	@Override
	public void delete(MemVO memVO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(MemVO memVO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemVO findByPrimaryKey(Integer cust_id) {
		MemVO memVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		return null;
	}
}
