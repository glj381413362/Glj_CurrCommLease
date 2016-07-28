package com.CCL.service.mlf;


import java.util.List;

import com.CCL.Dao.OpeUserDao;
import com.CCL.Dao.impl.OpeUserDaoImpl;
import com.CCL.beans.OpeUser;

public class Loginservice {
	private OpeUserDao Opdao;
	private OpeUser oper;
	private String name;
	private String pwd;
	public Loginservice()
	{
		Opdao=new OpeUserDaoImpl();
		oper=new OpeUser();
	}
	public Boolean isExixt(String name,String pwd)
	{
		this.name=name;		
		this.pwd=pwd;
		Boolean b=false;
		List<OpeUser> user=Opdao.queryAll();
		for(OpeUser u:user)
		{
			if(u.getUserName().equals(name)&&u.getPassword().equals(pwd))
			 {
				b=true;
			 }
		}
		return b;
	}
	public OpeUser selectByNameAndPwd(String name,String pwd)
	{
		this.name=name;		
		this.pwd=pwd;
		
		List<OpeUser> user=Opdao.queryAll();
		for(OpeUser u:user)
		{
			if(u.getUserName().equals(name)&&u.getPassword().equals(pwd))
			{
				oper=u;
			}
		}
		return oper;
	}

}
