package com.pb.dao;

import java.util.List;

import com.pb.entity.Bill;
import com.pb.vo.Page;

public interface BillDao {
	public boolean isLogin(Bill bill) throws Exception;

	public int addBill(Bill bill) throws Exception;

	public int deleteBill(Bill bill) throws Exception;

	public int updateBill(Bill bill) throws Exception;

	public Bill findBillById(int id) throws Exception;

	public List<Bill> findAllBills() throws Exception;

	// 分页查询
	public Page findBillsByPage(int currentPage, int pageSize) throws Exception;

	// 模糊查询
	public List<Bill> findBillsByMohu(String... keyWords) throws Exception;

	// 模糊和分页查询
	public Page findBillsByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception;

	// 判断时哪种权限登陆
	public boolean isAdminLogin(Bill bill) throws Exception;

	public boolean isManagerLogin(Bill bill) throws Exception;
}
