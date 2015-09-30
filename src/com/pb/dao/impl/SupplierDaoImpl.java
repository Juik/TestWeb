package com.pb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pb.dao.SupplierDao;
import com.pb.dao.common.BaseDao;
import com.pb.entity.Supplier;
import com.pb.vo.Page;

public class SupplierDaoImpl implements SupplierDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int addSupplier(Supplier supplier) throws Exception {
		int rowAffect = 0;
		con = BaseDao.getConnection();
		String sql = "insert into t_supplier (suppliername,contactman,phone,address) values(?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, supplier.getSupplierName());
		pstmt.setString(2, supplier.getContactman());
		pstmt.setString(3, supplier.getPhone());
		pstmt.setString(4, supplier.getAddress());
		rowAffect = pstmt.executeUpdate();

		BaseDao.closeAll(null, pstmt, con);
		return rowAffect;
	}

	@Override
	public int deleteSupplier(Supplier supplier) throws Exception {
		int rowAffect = 0;
		con = BaseDao.getConnection();
		String sql = "delete from t_supplier where sup_id = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, supplier.getsup_id());
		rowAffect = pstmt.executeUpdate();
		BaseDao.closeAll(null, pstmt, con);
		return rowAffect;
	}

	@Override
	public List<Supplier> findAllSuppliers() throws Exception {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		con = BaseDao.getConnection();
		String sql = "select sup_id,suppliername,contactman,phone,address from t_supplier";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Supplier supplier = new Supplier();
			supplier.setsup_id(rs.getInt("sup_id"));
			supplier.setSupplierName(rs.getString("suppliername"));
			supplier.setContactman(rs.getString("contactman"));
			supplier.setPhone(rs.getString("phone"));
			supplier.setAddress(rs.getString("address"));
			suppliers.add(supplier);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return suppliers;
	}

	@Override
	public Supplier findSupplierById(int id) throws Exception {
		System.out.println("enter supplierDaoImplt.findSupplierbyID");
		Supplier supplier = null;
		con = BaseDao.getConnection();
		String sql = "select * from t_supplier where sup_id = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			supplier = new Supplier();
			supplier.setsup_id(rs.getInt("sup_id"));
			supplier.setSupplierName(rs.getString("suppliername"));
			supplier.setContactman(rs.getString("contactman"));
			supplier.setPhone(rs.getString("phone"));
			supplier.setAddress(rs.getString("address"));
		}
		BaseDao.closeAll(rs, pstmt, con);
		return supplier;
	}

	private int getCount() throws Exception {
		int count = 0;
		con = BaseDao.getConnection();
		String sql = "select count(sup_id) as geshu from t_supplier";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("geshu");
		}
		BaseDao.closeAll(rs, pstmt, con);
		return count;
	}

	// 只限制它可以模糊查询供应商姓名和联系人姓名
	@Override
	public List<Supplier> findSuppliersByMohu(String... keyWords)
			throws Exception {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		con = BaseDao.getConnection();
		String sql = "select * from t_supplier where suppliername like ? AND contactman like ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyWords[0] + "%");
		pstmt.setString(2, "%" + keyWords[1] + "%");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Supplier supplier = new Supplier();
			supplier.setsup_id(rs.getInt("sup_id"));
			supplier.setSupplierName(rs.getString("suppliername"));
			supplier.setContactman(rs.getString("contactman"));
			supplier.setPhone(rs.getString("phone"));
			supplier.setAddress(rs.getString("address"));
			suppliers.add(supplier);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return suppliers;
	}

	@Override
	public Page findSuppliersByPage(int currentPage, int pageSize)
			throws Exception {
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
		page.setCurrentPageData(this.findSuppliersByPageImpl(currentPage,
				pageSize));
		page.setNextPage(nextPage);
		page.setPageSize(pageSize);
		page.setPreviousPage(previousPage);
		page.setTotalCount(count);
		page.setTotalPage(totalPage);
		return page;
	}

	private List<Supplier> findSuppliersByPageImpl(int currentPage, int pageSize)
			throws Exception {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		con = BaseDao.getConnection();
		String sql = "select * from t_supplier limit ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, (currentPage - 1) * pageSize);
		pstmt.setInt(2, pageSize);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Supplier supplier = new Supplier();
			supplier.setsup_id(rs.getInt("sup_id"));
			supplier.setSupplierName(rs.getString("suppliername"));
			supplier.setContactman(rs.getString("contactman"));
			supplier.setPhone(rs.getString("phone"));
			supplier.setAddress(rs.getString("address"));
			suppliers.add(supplier);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return suppliers;
	}

	private int getCount(String... keyWords) {
		int count = 0;
		System.out.println("k1:" + keyWords[0] + "k2:" + keyWords[1]);
		con = BaseDao.getConnection();
		String sql = "select count(sup_id) as geshu from t_supplier where suppliername like ? AND contactman like ?;";
		try {
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
	public Page findSuppliersByPageAndMohu(int currentPage, int pageSize,
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
		page.setCurrentPageData(this.findSuppliersByPageAndMohuImpl(
				currentPage, pageSize, keyWords));
		page.setNextPage(nextPage);
		page.setPageSize(pageSize);
		page.setPreviousPage(previousPage);
		page.setTotalCount(count);
		page.setTotalPage(totalPage);
		return page;
	}

	private List findSuppliersByPageAndMohuImpl(int currentPage, int pageSize,
			String[] keyWords) throws Exception {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		con = BaseDao.getConnection();
		String sql = "select * from t_supplier where suppliername like ? AND contactman like ? limit ?,?;";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyWords[0] + "%");
		pstmt.setString(2, "%" + keyWords[1] + "%");
		pstmt.setInt(3, (currentPage - 1) * pageSize);
		pstmt.setInt(4, pageSize);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Supplier supplier = new Supplier();
			supplier.setsup_id(rs.getInt("sup_id"));
			supplier.setSupplierName(rs.getString("suppliername"));
			supplier.setContactman(rs.getString("contactman"));
			supplier.setPhone(rs.getString("phone"));
			supplier.setAddress(rs.getString("address"));
			suppliers.add(supplier);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return suppliers;
	}

	@Override
	public int updateSupplier(Supplier supplier) throws Exception {
		int rowAffect = 0;
		con = BaseDao.getConnection();
		System.out.println(supplier.getSupplierName() + " "
				+ supplier.getContactman() + " " + supplier.getPhone() + " "
				+ supplier.getAddress() + " " + supplier.getsup_id());
		String sql = "update t_supplier set suppliername =?,contactman=? where sup_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, supplier.getSupplierName());
		pstmt.setString(2, supplier.getContactman());
		pstmt.setInt(3, supplier.getsup_id());
		rowAffect = pstmt.executeUpdate();
		BaseDao.closeAll(null, pstmt, con);
		return rowAffect;
	}

}
