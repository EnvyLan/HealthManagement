package com.zcf.dao;

import com.zcf.bean.BeanUser;

public interface UserDaoImp {
	boolean getUser(BeanUser myUser);
	boolean modifyUser(BeanUser myUser);
	boolean deleteUser(BeanUser myUser);
}
