package com.CCL.view.kaitaimgr.service;

import java.util.List;

import com.CCL.Dao.BicycleDao;
import com.CCL.Dao.BicycleTypeDao;
import com.CCL.Dao.impl.BicycleDaoImpl;
import com.CCL.Dao.impl.BicycleTypeDaoImpl;
import com.CCL.beans.Bicycle;
import com.CCL.beans.BicycleType;

public class BicycleService {

	static BicycleDao bd = new BicycleDaoImpl();
	public static BicycleTypeDao btd = new BicycleTypeDaoImpl();

	public static List<BicycleType> getAllType() {

		return btd.queryAll();
	}

	public static List<Bicycle> queryByType(BicycleType selectedItem) {
		return bd.queryByType(selectedItem);
	}

}
