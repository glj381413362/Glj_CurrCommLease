package com.CCL.view.operatormgr.model;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.CCL.Dao.OpeUserDao;
import com.CCL.beans.OpeUser;

public class OperatorTableModel extends DefaultTableModel {

	OpeUserDao opeUserDao = null;
	List<OpeUser> allUser = null;

	public OperatorTableModel(OpeUserDao opeUserDao) {
		super(null, new String[] { "ÐÕÃû", "ÐÔ±ð" });
		this.opeUserDao = opeUserDao;
		upDate();

	}

	void upDate() {
		List<OpeUser> all = opeUserDao.queryAll();

		if (allUser != null)
			for (OpeUser user : allUser) {
				this.insertRow(1, new String[] { user.getName(), user.getSex() });
		}
	}

}
