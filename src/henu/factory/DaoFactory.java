package henu.factory;

import henu.dao.IF.DaoIF;
import henu.dao.IF.saleDaoIF;
import henu.dao.impl.DaoImpl;
import henu.dao.impl.saleDaoImpl;

public class DaoFactory {
	public static DaoIF getUserDaoInstance()
	{
		return new DaoImpl();
	}
	public static saleDaoIF getsalerDaoInstance()
	{
		return new saleDaoImpl();
	}
}
