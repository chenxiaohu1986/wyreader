package com.ihandy.wyreader.db.helper;

import com.ihandy.wyreader.db.entity.UserBean;
import com.ihandy.wyreader.db.gen.DaoSession;
import com.ihandy.wyreader.db.gen.UserBeanDao;

/**
 * Created by cxh on 18/5/21.
 */

public class UserHelper {

	private static volatile UserHelper sInstance;
	private static DaoSession daoSession;
	private static UserBeanDao userBeanDao;

	public static UserHelper getsInstance() {
		if (sInstance == null){
			synchronized (UserHelper.class){
				if (sInstance == null) {
					sInstance = new UserHelper();
					daoSession = DaoDbHelper.getInstance().getSession();
					userBeanDao = daoSession.getUserBeanDao();
				}
			}
		}

		return sInstance;
	}

	/**
	 * 保存用户
	 *
	 * @param userBean
	 */
	public void saveUser(UserBean userBean){
		userBeanDao.insertOrReplace(userBean);
	}


	/**
	 * 更新用户信息
	 *
	 * @param userBean
	 */
	public void updateUser(UserBean userBean) {
		userBeanDao.update(userBean);
	}

	/**
	 * 删除用户
	 */
	public void removeUser() {
		userBeanDao.deleteAll();
	}

	/**
	 * 根据用户名查询用户信息
	 *
	 * @param username
	 * @return
	 */
	public UserBean findUserByName(String username) {
		return userBeanDao.queryBuilder().where(UserBeanDao.Properties.Name.eq(username)).unique() != null
				? userBeanDao.queryBuilder().where(UserBeanDao.Properties.Name.eq(username)).unique() : null;
	}

}
