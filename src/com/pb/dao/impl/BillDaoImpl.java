package com.pb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pb.dao.BillDao;
import com.pb.dao.common.BaseDao;
import com.pb.entity.Bill;
import com.pb.vo.Page;

public class BillDaoImpl implements BillDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int addBill(Bill bill) throws Exception {
		int rowAffect = 0;
		con = BaseDao.getConnection();
		String sql = "insert into t_bill(productname,amount,price,pay,suppliername,billtime,saleworker) values(?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bill.getproductName());
		pstmt.setInt(2, bill.getAmount());
		pstmt.setFloat(3, bill.getPrice());
		pstmt.setFloat(4, bill.getPay());
		pstmt.setString(5, bill.getsupplierName());
		pstmt.setString(6, bill.getBilltime());
		pstmt.setString(7, bill.getsaleworker());
		rowAffect = pstmt.executeUpdate();
		BaseDao.closeAll(null, pstmt, con);
		return rowAffect;
	}

	@Override
	public int deleteBill(Bill bill) throws Exception {
		int rowAffects = 0;
		con = BaseDao.getConnection();
		String sql = "delete from t_bill where bill_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bill.getBill_id());
		rowAffects = pstmt.executeUpdate();
		BaseDao.closeAll(null, pstmt, con);
		return rowAffects;
	}

	@Override
	public int updateBill(Bill bill) throws Exception {
		int rowAffects = 0;
		con = BaseDao.getConnection();
		String sql = "update t_bill  set productname = ?,suppliername=?,amount=?,price=?,pay=?,billtime=?,saleworker=? where bill_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bill.getproductName());
		pstmt.setString(2, bill.getsupplierName());
		pstmt.setInt(3, bill.getAmount());
		pstmt.setFloat(4, bill.getPrice());
		pstmt.setFloat(5, bill.getPay());
		pstmt.setString(6, bill.getBilltime());
		pstmt.setString(7, bill.getsaleworker());
		pstmt.setInt(8, bill.getBill_id());
		rowAffects = pstmt.executeUpdate();
		BaseDao.closeAll(null, pstmt, con);
		return rowAffects;
	}

	@Override
	public List<Bill> findAllBills() throws Exception {
		List<Bill> bills = new ArrayList<Bill>();
		con = BaseDao.getConnection();
		String sql = "select bill_id,productname,amount,price,pay,suppliername,billtime,saleworker from t_bill";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Bill bill = new Bill();
			bill.setBill_id(rs.getInt("bill_id"));
			bill.setproductName(rs.getString("productname"));
			bill.setAmount(rs.getInt("amount"));
			bill.setPrice(rs.getFloat("price"));
			bill.setPay(rs.getFloat("pay"));
			bill.setsupplierName(rs.getString("suppliername"));
			bill.setsaleworker(rs.getString("saleworker"));
			bill.setBilltime(rs.getString("billtime"));
			bills.add(bill);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return bills;
	}

	@Override
	public Bill findBillById(int id) throws Exception {
		Bill bill = new Bill();
		con = BaseDao.getConnection();
		String sql = "select bill_id,productname,amount,price,pay,suppliername,billtime,saleworker from t_bill where bill_id = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			bill.setproductName(rs.getString("productname"));
			bill.setAmount(rs.getInt("amount"));
			bill.setPrice(rs.getFloat("price"));
			bill.setPay(rs.getFloat("pay"));
			bill.setsupplierName(rs.getString("suppliername"));
			bill.setBilltime(rs.getString("billtime"));
			bill.setsaleworker(rs.getString("saleworker"));
			bill.setBill_id(Integer.parseInt(rs.getString("bill_id")));
		}
		BaseDao.closeAll(rs, pstmt, con);
		return bill;
	}

	// 只限制他可以查询订单商品名称，供应商姓名，时间和saleworker是谁的模糊。
	@Override
	public List<Bill> findBillsByMohu(String... keyWords) throws Exception {
		List<Bill> bills = new ArrayList<Bill>();
		con = BaseDao.getConnection();
		String sql = "select * from t_bill where productname like ? AND suppliername like? AND billtime like ? AND saleworker like ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyWords[0] + "%");
		pstmt.setString(2, "%" + keyWords[1] + "%");
		pstmt.setString(3, "%" + keyWords[2] + "%");
		pstmt.setString(4, "%" + keyWords[3] + "%");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Bill bill = new Bill();
			bill.setBill_id(Integer.parseInt(rs.getString("bill_id")));
			bill.setproductName(rs.getString("productname"));
			bill.setAmount(rs.getInt("amount"));
			bill.setPrice(rs.getFloat("price"));
			bill.setPay(rs.getFloat("pay"));
			bill.setsupplierName(rs.getString("suppliername"));
			bill.setBilltime(rs.getString("billtime"));
			bill.setsaleworker(rs.getString("saleworker"));
			bills.add(bill);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return bills;
	}

	private int getCount() throws Exception {
		int count = 0;
		con = BaseDao.getConnection();
		String sql = "select count(bill_id) as geshu from t_bill";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("geshu");
		}
		BaseDao.closeAll(rs, pstmt, con);
		return count;
	}

	@Override
	public Page findBillsByPage(int currentPage, int pageSize) throws Exception {
		Page page = new Page();
		int count = this.getCount();
		// 如何总count数可以被pageSize整除，则取这个数，否则取这个数加一
		int totalPage = count % pageSize == 0 ? count / pageSize
				: ((count / pageSize) + 1);
		int previousPage = 0;
		if (currentPage == 1) {
			previousPage = 1;
		} else {
			previousPage = currentPage - 1;
		}
		int nextPage = 0;
		if (currentPage == totalPage) {
			nextPage = totalPage;
		} else {
			nextPage = currentPage + 1;
		}
		page.setCurrentPage(currentPage);
		page
				.setCurrentPageData(this.findBillsByPageImpl(currentPage,
						pageSize));
		page.setNextPage(nextPage);
		page.setPageSize(pageSize);
		page.setPreviousPage(previousPage);
		page.setTotalCount(count);
		page.setTotalPage(totalPage);
		return page;
	}

	private List<Bill> findBillsByPageImpl(int currentPage, int pageSize)
			throws Exception {
		List<Bill> bills = new ArrayList<Bill>();
		con = BaseDao.getConnection();
		String sql = "select * from t_bill limit ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, (currentPage - 1) * pageSize);
		pstmt.setInt(2, pageSize);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Bill bill = new Bill();
			bill.setBill_id(rs.getInt("bill_id"));
			bill.setproductName(rs.getString("productname"));
			bill.setAmount(rs.getInt("amount"));
			bill.setPrice(rs.getFloat("price"));
			bill.setPay(rs.getFloat("pay"));
			bill.setsupplierName(rs.getString("suppliername"));
			bill.setBilltime(rs.getString("billtime"));
			bill.setsaleworker(rs.getString("saleworker"));
			bills.add(bill);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return bills;
	}

	private int getCount(String... keyWords) {
		int count = 0;
		con = BaseDao.getConnection();
		try {
			String sql = "select count(bill_id) as geshu from t_bill where productname like ? AND suppliername like ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyWords[0] + "%");
			pstmt.setString(2, "%" + keyWords[1] + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("geshu");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDao.closeAll(rs, pstmt, con);
		return count;
	}

	@Override
	public Page findBillsByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception {
		Page page = new Page();
		int count = this.getCount(keyWords);
		int totalPage = count % pageSize == 0 ? count / pageSize
				: ((count / pageSize) + 1);
		int previousPage = 0;
		if (currentPage == 1) {
			previousPage = 1;
		} else {
			previousPage = currentPage - 1;
		}
		int nextPage = 0;
		if (currentPage == totalPage) {
			nextPage = totalPage;
		} else {
			nextPage = currentPage + 1;
		}
		page.setCurrentPage(currentPage);
		page.setCurrentPageData(this.findBillsByPageAndMohuImpl(currentPage,
				pageSize, keyWords));
		page.setNextPage(nextPage);
		page.setPageSize(pageSize);
		page.setPreviousPage(previousPage);
		page.setTotalCount(count);
		page.setTotalPage(totalPage);
		return page;
	}

	private List<Bill> findBillsByPageAndMohuImpl(int currentPage,
			int pageSize, String[] keyWords) throws Exception {
		List<Bill> bills = new ArrayList<Bill>();
		con = BaseDao.getConnection();
		String sql = "select * from t_bill where productname like ? AND suppliername like ? limit ?,?;";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyWords[0] + "%");
		pstmt.setString(2, "%" + keyWords[1] + "%");
		pstmt.setInt(3, (currentPage - 1) * pageSize);
		pstmt.setInt(4, pageSize);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Bill bill = new Bill();
			bill.setBill_id(rs.getInt("bill_id"));
			bill.setproductName(rs.getString("productname"));
			bill.setAmount(rs.getInt("amount"));
			bill.setPrice(rs.getFloat("price"));
			bill.setPay(rs.getFloat("pay"));
			bill.setsupplierName(rs.getString("suppliername"));
			bill.setBilltime(rs.getString("billtime"));
			bill.setsaleworker(rs.getString("saleworker"));
			bills.add(bill);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return bills;
	}

	@Override
	public boolean isAdminLogin(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLogin(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isManagerLogin(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
