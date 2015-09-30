package com.pb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pb.dao.BillDao;
import com.pb.dao.impl.BillDaoImpl;
import com.pb.entity.Bill;
import com.pb.entity.User;
import com.pb.service.BillService;
import com.pb.vo.Page;

public class BillServiceImpl implements BillService {
	private BillDao billDao = new BillDaoImpl();

	@Override
	public boolean addBill(Bill bill) {
		boolean flag = false;
		try {
			int rowAffects = billDao.addBill(bill);
			if (rowAffects == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteBill(Bill bill) {
		boolean flag = false;
		try {
			int rowAffects = billDao.deleteBill(bill);
			if (rowAffects == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateBill(Bill bill) {
		boolean flag = false;
		try {
			int rowAffects = billDao.updateBill(bill);
			if (rowAffects > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Bill> findAllBills() {
		List<Bill> bills = new ArrayList<Bill>();
		try {
			bills = billDao.findAllBills();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bills;
	}

	@Override
	public Bill findBillById(Integer id) {
		Bill bill = new Bill();
		try {
			bill = billDao.findBillById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bill;
	}

	@Override
	public Page findBillsByPage(int currentPage, int pageSize) throws Exception {
		Page page = new Page();
		page = billDao.findBillsByPage(currentPage, pageSize);
		return page;
	}

	@Override
	public Page findBillsByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception {
		Page page = new Page();
		page = billDao.findBillsByPageAndMohu(currentPage, pageSize, keyWords);
		return page;
	}

	@Override
	public List<Bill> findbillsByMohu(String... keyWords) throws Exception {
		List<Bill> bills = new ArrayList<Bill>();
		bills = billDao.findBillsByMohu(keyWords);
		return bills;
	}

	@Override
	public boolean isAdminLogin(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLogin(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSManagerLogin(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
