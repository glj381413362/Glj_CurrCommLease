package com.CCL.view.operatormgr.service;

import com.CCL.beans.OpeUser;

public class OpeUserService {

	public static boolean update(OpeUser updateOpeUser) {
		
		if(updateOpeUser ==null) return false;
		System.out.println("以保存用户"+updateOpeUser.getName()+"更新");
		
		return true;
	}

}
