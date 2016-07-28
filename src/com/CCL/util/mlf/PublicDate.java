package com.CCL.util.mlf;

import com.CCL.Dao.OpeperDao;
import com.CCL.Dao.impl.OpeperDaoImpl;
import com.CCL.beans.OpeUser;
import com.CCL.beans.Opeper;

public class PublicDate {
	private static OpeUser ouser=null;
	static OpeperDao Opeperdao = new OpeperDaoImpl();
	public static OpeUser getOuser() {
		return ouser;
	}

	public static void setOuser(OpeUser ouser) {
		PublicDate.ouser = ouser;
	}

	
	
	@SuppressWarnings("unused")
	public static Opeper getOpeper(OpeUser opeuser)
	{
		Opeper opeper =null;
		if(opeper!=null)
		{
			opeper = Opeperdao.get(opeuser.getOpePer().getId());
		}
		
	return opeper;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
