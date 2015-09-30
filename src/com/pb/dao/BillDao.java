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

	// ��ҳ��ѯ
	public Page findBillsByPage(int currentPage, int pageSize) throws Exception;

	// ģ����ѯ
	public List<Bill> findBillsByMohu(String... keyWords) throws Exception;

	// ģ���ͷ�ҳ��ѯ
	public Page findBillsByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception;

	// �ж�ʱ����Ȩ�޵�½
	public boolean isAdminLogin(Bill bill) throws Exception;

	public boolean isManagerLogin(Bill bill) throws Exception;
}
