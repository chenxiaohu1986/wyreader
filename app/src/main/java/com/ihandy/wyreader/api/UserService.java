package com.ihandy.wyreader.api;

import com.allen.library.bean.BaseData;
import com.ihandy.wyreader.model.AppUpdateBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by cxh on 18/5/16.
 */

public interface UserService {



	/**
	 * 用户反馈
	 *
	 * @return
	 */
	@GET(ModelPath.API + "/appupdate")
	Observable<BaseData<AppUpdateBean>> appUpdate();
}
