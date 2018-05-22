package com.ihandy.wyreader.api;

import com.allen.library.bean.BaseData;
import com.ihandy.wyreader.db.entity.UserBean;
import com.ihandy.wyreader.model.AppUpdateBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cxh on 18/5/16.
 */

public interface UserService {



	/**
	 * 用户登录
	 *
	 * @return
	 */
	@GET(ModelPath.USER + "/login")
	Observable<BaseData<UserBean>> login(@Query("name") String username, @Query("password") String password);





	/**
	 * 用户反馈
	 *
	 * @return
	 */
	@GET(ModelPath.API + "/appupdate")
	Observable<BaseData<AppUpdateBean>> appUpdate();
}
