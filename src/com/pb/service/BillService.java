package com.pb.service;

import java.util.List;

import com.pb.entity.Bill;
import com.pb.entity.User;
import com.pb.vo.Page;

public interface BillService {
	public boolean isLogin(User user);

	// 判断是什么用户登陆
	public boolean isAdminLogin(User user);

	public boolean isSManagerLogin(User user);

	public boolean addBill(Bill bill);

	public boolean deleteBill(Bill bill);

	public boolean updateBill(Bill bill);

	public Bill findBillById(Integer id);

	public List<Bill> findAllBills();

	public Page findBillsByPage(int currentPage, int pageSize) throws Exception;

	public List<Bill> findbillsByMohu(String... keyWords) throws Exception;

	public Page findBillsByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception;
}
