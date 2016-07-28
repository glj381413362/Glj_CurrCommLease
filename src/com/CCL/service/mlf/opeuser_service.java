package com.CCL.service.mlf;

import java.util.List;

import com.CCL.Dao.OpeUserDao;
import com.CCL.beans.CustomerType;
import com.CCL.beans.OpeUser;

public class opeuser_service {
	private static OpeUserDao Opdao;

public static List<OpeUser> getAllType() {
		
		return Opdao.queryAll();
	}
}
