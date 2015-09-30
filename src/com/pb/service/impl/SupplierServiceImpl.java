package com.pb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pb.dao.SupplierDao;
import com.pb.dao.impl.SupplierDaoImpl;
import com.pb.entity.Supplier;
import com.pb.entity.User;
import com.pb.service.SupplierService;
import com.pb.vo.Page;

public class SupplierServiceImpl implements SupplierService {
	private SupplierDao supplierDao = new SupplierDaoImpl();

	@Override
	public boolean addSupplier(Supplier supplier) {
		boolean flag = false;
		try {
			int rowAffects = supplierDao.addSupplier(supplier);
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
	public boolean deleteSupplier(Supplier supplier) {
		boolean flag = false;
		try {
			int rowAffets = supplierDao.deleteSupplier(supplier);
			if (rowAffets == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Supplier> findAllSuppliers() {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		try {
			suppliers = supplierDao.findAllSuppliers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suppliers;
	}

	@Override
	public Supplier findSupplierById(Integer id) {
		Supplier supplier = new Supplier();
		try {
			supplier = supplierDao.findSupplierById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return supplier;
	}

	@Override
	public List<Supplier> findSuppliersByMohu(String... keyWords)
			throws Exception {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		suppliers = supplierDao.findSuppliersByMohu(keyWords);
		return suppliers;
	}

	@Override
	public Page findSuppliersByPage(int currentPage, int pageSize)
			throws Exception {
		Page page = new Page();
		page = supplierDao.findSuppliersByPage(currentPage, pageSize);
		return page;
	}

	@Override
	public Page findSuppliersByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception {
		Page page = new Page();
		page = supplierDao.findSuppliersByPageAndMohu(currentPage, pageSize,
				keyWords);
		return page;
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		boolean flag = false;
		int rowAffects = 0;
		try {
			rowAffects = supplierDao.updateSupplier(supplier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rowAffects > 0)
			flag = true;
		return flag;
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
